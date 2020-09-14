package utils

import com.google.firebase.auth.{FirebaseAuth, FirebaseToken}

object Utils extends App {
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
}
