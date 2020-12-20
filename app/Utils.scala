import com.google.api.Authentication
import com.google.firebase.auth.UserRecord._
import com.google.firebase.auth.{FirebaseAuth, FirebaseAuthException, UserRecord}
import org.json4s.DefaultFormats
import org.json4s.native.{JsonMethods, Serialization}
import play.api.mvc.{AnyContent, Request, RequestHeader}
import com.typesafe.config._

package object Utils {

  implicit class Pipeline[T](x: T) {
    def |>[S](f: T => S): S = f(x)
  }

  implicit val formats: DefaultFormats.type = DefaultFormats

  def convertReqToModel[T: Manifest](request: Request[AnyContent]): Option[T] =
    request.body.asJson.flatMap { value =>
      JsonMethods.parse(value.toString).extractOpt[T]
    }

  def convertModelToResp[T](model: T): String = Serialization.write(model)

  def getIdToken[T <: RequestHeader](rh: T): Option[String] = rh.headers.get("Authorization")

  def getFirebaseUid[T <: RequestHeader](rh: T): Option[String] = getIdToken(rh).flatMap(getFirebaseUid)

  private def getFirebaseUid(idToken: String): Option[String] =
    try Some(FirebaseAuth.getInstance.verifyIdToken(idToken).getUid)
    catch {
      case err: FirebaseAuthException => println(err)
        None
    }


  def updateFirebasePassword(uid: String)(newPassword: String): Option[String] =
    try Some((new UpdateRequest(uid).setPassword(newPassword) |> FirebaseAuth.getInstance.updateUser).getUid)
    catch {
      case err: FirebaseAuthException => println(err)
        None
    }

  def checkIdentification(uid: String)(password: String): Boolean = {
    FirebaseAuth.getInstance.

  }

  def responseError(errorStatus: String): String =
    convertModelToResp {
      ("message", ConfigFactory.load().getString(s"error.$errorStatus"))
    }
}
