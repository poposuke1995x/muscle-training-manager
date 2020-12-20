package filters

import Utils.{Pipeline, convertModelToResp, getFirebaseUid, responseError}
import akka.stream.Materializer
import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.{FirebaseApp, FirebaseOptions}
import com.google.inject.Inject
import play.api.Configuration
import play.api.mvc.Results.{Forbidden, InternalServerError}
import play.api.mvc.{Filter, RequestHeader, Result}
import usecase.UserService

import java.io.FileInputStream
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
    rh.path match {
      case "/" => nextFilter(rh)
//      case "/body_parts" => nextFilter(rh)
      case _ => filterByFirebaseAuth(nextFilter)(rh)
    }

  def filterByFirebaseAuth(nextFilter: RequestHeader => Future[Result])(rh: RequestHeader): Future[Result] =
    rh |> getFirebaseUid match {
      case Some(uid) => addUserIdToHeader(uid).flatMap {
        case Left(value) => Future(value)
        case Right(value) => nextFilter(rh).map(_.withHeaders(value))
      }
      case None => Future(Forbidden(responseError("Forbidden")))
    }

  def addUserIdToHeader(uid: String): Future[Either[Result, (String, String)]] =
    userService.getUserId(uid).flatMap {
      case Some(id) => Future(Right(("user_id", id.toString)))
      case None => userService.createGuestUser(uid).map {
        case Some(userId) => Right(("user_id", userId.toString))
        case None => Left(InternalServerError(responseError("InternalServerError")))
      }
    }
}