package filters

import java.io.FileInputStream

import akka.stream.Materializer
import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.{FirebaseApp, FirebaseOptions}
import com.google.inject.Inject
import play.api.Configuration
import play.api.mvc.Results.Forbidden
import play.api.mvc.{Filter, RequestHeader, Result}
import utils.Utils

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}

class AuthFilter @Inject()(config: Configuration, utils: Utils)(implicit executionContext: ExecutionContext, implicit val mat: Materializer) extends Filter {
  val serviceAccount = new FileInputStream(config.get[String]("secret.key.path"))
  val options: FirebaseOptions =
    new FirebaseOptions.Builder()
      .setCredentials(GoogleCredentials.fromStream(serviceAccount))
      .build
  FirebaseApp.getApps.size match {
    case 0 => FirebaseApp.initializeApp(options)
    case _ => FirebaseApp.getApps.get(0)
  }


  def apply(nextFilter: RequestHeader => Future[Result])(rh: RequestHeader): Future[Result] = {
    implicit def Pipeline[T](x: T): utils.Pipeline[T] = utils.Pipeline(x)

    rh.headers.get("Authorization").getOrElse("") |> utils.getFirebaseUid match {
      case uid if uid.nonEmpty => nextFilter(rh).map(_.withHeaders {
        val userId = utils.getUserId(uid)
        Await.ready(userId, Duration.Inf)
        userId.value.get match {
          case Success(value) => value match {
            case 0 =>
              val createdUserId = uid |> utils.createGuestUser
              Await.ready(createdUserId, Duration.Inf)
              createdUserId.value.get match {
                case Success(value) => ("user_id", value.toString)
                case Failure(exception) => ("user_id", exception.toString)
              }
            case _ => ("user_id", value.toString)
          }
          case Failure(exception) => ("user_id", exception.toString)
        }
      })
      case _ => Future(Forbidden("invalid"))
    }
  }
}
