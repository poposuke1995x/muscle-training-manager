package utils

import com.google.firebase.auth.{FirebaseAuth, FirebaseToken}
import com.google.inject.Inject
import domain.{User, UserRepositoryInterface}

import scala.concurrent.{ExecutionContext, Future}
import scala.language.implicitConversions
import scala.language.reflectiveCalls


case class Utils @Inject()(repository: UserRepositoryInterface)(implicit executionContext: ExecutionContext) {
  case class Pipeline[T](x: T) {
    def |>[S](f: T => S): S = f(x)
  }
  // ####### usage #######
  //implicit def Pipeline[T](x: T) = new Pipeline(x)
  def getFirebaseUid(idToken: String): String =  {
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

  def getUserId(firebaseUid: String): Future[Int] = repository.findIdByUid(firebaseUid)

  def createGuestUser(uid: String): Future[Int] = repository.insert(User(Some(0), "guest", uid))

}
