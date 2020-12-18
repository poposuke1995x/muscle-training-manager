import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserRecord.UpdateRequest

package object Utils {

  implicit class Pipeline[T](x: T) {
    def |>[S](f: T => S): S = f(x)
  }

  def getFirebaseUid(idToken: String): String =
    try FirebaseAuth.getInstance.verifyIdToken(idToken).getUid
    catch {
      case err: Any => println(err)
        ""
    }

  def updateFirebasePassword(uid: String)(newPassword: String): String =
    try (new UpdateRequest(uid).setPassword(newPassword) |> FirebaseAuth.getInstance.updateUser).getUid
    catch {
      case err: Any =>
        println(err)
        ""
    }
}
