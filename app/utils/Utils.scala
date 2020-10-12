package utils

import com.google.firebase.auth.{FirebaseAuth, FirebaseToken}
import com.google.inject.Inject
import domain.UserRepositoryInterface

import scala.concurrent.{ExecutionContext, Future}


case class Utils @Inject()(repository: UserRepositoryInterface)(implicit executionContext: ExecutionContext) {
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

  def getUserId(idToken: String): Future[Int] = repository.findIdByUid(getFirebaseUid(idToken))
}
