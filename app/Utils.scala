import com.google.firebase.auth.FirebaseAuth

package object Utils {

  implicit class Pipeline[T](x: T) {
    def |>[S](f: T => S): S = f(x)
  }

  def getFirebaseUid(idToken: String): String =
    try FirebaseAuth.getInstance.verifyIdToken(idToken).getUid
    catch {
      case _: Any => ""
    }
}
