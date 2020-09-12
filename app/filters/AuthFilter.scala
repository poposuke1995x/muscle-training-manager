package filters

import java.io.FileInputStream
import java.util
import akka.stream.Materializer
import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.{FirebaseApp, FirebaseOptions}
import com.google.firebase.auth.{FirebaseAuth, FirebaseToken}
import com.google.inject.Inject
import play.api.Configuration
import play.api.mvc.Results.Forbidden
import play.api.mvc.{Filter, RequestHeader, Result}
import scala.concurrent.{ExecutionContext, Future}

class AuthFilter @Inject() (config: Configuration)(implicit executionContext: ExecutionContext, implicit val mat: Materializer) extends Filter {
  val serviceAccount = new FileInputStream(config.get[String]("secret.key.path"))
  val options: FirebaseOptions =
    new FirebaseOptions.Builder()
      .setCredentials(GoogleCredentials.fromStream(serviceAccount))
      .build
  val apps: util.List[FirebaseApp] = FirebaseApp.getApps
  apps.size match {
    case 0 => FirebaseApp.initializeApp(options)
    case _ => apps.get(0)
  }

  def apply(nextFilter: RequestHeader => Future[Result])(rh: RequestHeader): Future[Result] = {
    val uid = getUid(rh.headers.get("Authorization").getOrElse(""))
    if (checkAuth(uid)) {
      nextFilter(rh)
    } else {
      Future {
        Forbidden("invalid")
      }
    }
  }

  def getUid(idToken: String): String =  {
    val decodedToken: Option[FirebaseToken] =
      try {
        Some(FirebaseAuth.getInstance.verifyIdToken(idToken))
      }
      catch {
        case _: Any => None
      }

    decodedToken match {
      case Some(dToken) => dToken.getUid
      case None => ""
    }
  }
//FixMe: デプロイ前に修正
//  def checkAuth(uid: String): Boolean = uid.nonEmpty
  def checkAuth(uid: String): Boolean = true

}
