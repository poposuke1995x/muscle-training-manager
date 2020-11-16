package filters

import java.io.FileInputStream

import Utils.{Pipeline, getFirebaseUid}
import akka.stream.Materializer
import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.{FirebaseApp, FirebaseOptions}
import com.google.inject.Inject
import play.api.Configuration
import play.api.mvc.Results.Forbidden
import play.api.mvc.{Filter, RequestHeader, Result}
import usecase.UserService

import scala.concurrent.{ExecutionContext, Future}

class AuthFilter @Inject()(config: Configuration, userService: UserService)(
    implicit executionContext: ExecutionContext,
    implicit val mat: Materializer
) extends Filter {

  val serviceAccount = new FileInputStream(
    config.get[String]("secret.key.path")
  )
  val options: FirebaseOptions =
    new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build
  FirebaseApp.getApps.size match {
    case 0 => FirebaseApp.initializeApp(options)
    case _ => FirebaseApp.getApps.get(0)
  }

  def apply(nextFilter: RequestHeader => Future[Result])(rh: RequestHeader): Future[Result] =
    rh.headers.get("Authorization").getOrElse("") |> getFirebaseUid match {
      case uid if uid.nonEmpty => addUserIdToHeader(uid).flatMap { userIdHeader =>
        nextFilter(rh).map(_.withHeaders(userIdHeader))
      }
      case _ => Future(Forbidden("invalid"))
    }

  def addUserIdToHeader(uid: String): Future[(String, String)] =
    userService.getUserId(uid).flatMap {
      case 0 => userService.createGuestUser(uid).map { userId =>
        ("user_id", userId.toString)
      }
      case id => Future(("user_id", id.toString))
    }
}
