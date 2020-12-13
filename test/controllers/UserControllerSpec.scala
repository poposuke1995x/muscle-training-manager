package controllers

import Utils.Pipeline
import com.google.firebase.auth.FirebaseAuth
import org.json4s.DefaultFormats
import org.json4s.native.{JsonMethods, Serialization}
import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.Play.materializer
import play.api.libs.json.{JsValue, Json}
import play.api.libs.ws.WSClient
import play.api.test.Helpers._
import play.api.test._

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

class UserControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  implicit val formats: DefaultFormats.type = DefaultFormats
  val uid = "kthP6Uri5DRbs5KwEG07krKp2XU2"

  case class FirebaseResponse(
      kind: String,
      idToken: String,
      refreshToken: String,
      expiresIn: String,
      isNewUser: Boolean
  )

  def getCustomToken(uid: String): String = FirebaseAuth.getInstance.createCustomToken(uid)

  def getIdToken(customToken: String): Future[String] = {
    val ws: WSClient = app.injector.instanceOf(classOf[WSClient])
    val url = "https://www.googleapis.com/identitytoolkit/v3/relyingparty/verifyCustomToken?key=AIzaSyCbFtHNSrYoUUESkn_r51E3teBL-zkCBH8"
    ws.url(url)
        .post(Serialization.write(Map("token" -> customToken, "returnSecureToken" -> true)))
        .map(response => JsonMethods
            .parse(response.json.toString)
            .extractOpt[FirebaseResponse] match {
          case Some(value) => value.idToken
          case None => ""
        })
  }

  def generateTestCase(newPassword: String)(confirmPassword: String):JsValue =
    Json.parse(
      s"""{
         |   "newPassword": "$newPassword",
         |   "confirmPassword": "$confirmPassword"
         |}""".stripMargin)


  "UserController PATCH" should {

    "パスワードを更新したユーザーのIDを返却" in {

      val futureIdToken = getCustomToken(uid) |> getIdToken
      Await.ready(futureIdToken, Duration.Inf)
      val idToken = futureIdToken.value.get.get

      val request = FakeRequest(PATCH, "/users/password")
          .withHeaders(
            ("Authorization", idToken)
          )
          .withJsonBody(
            generateTestCase("scalaTest04")("scalaTest04")
          )

      val response = route(app, request).get

      status(response) mustBe OK
      contentAsString(response) mustEqual "2"
    }

    "パスワードが記号を含む" in {

      val futureIdToken = getCustomToken(uid) |> getIdToken
      Await.ready(futureIdToken, Duration.Inf)
      val idToken = futureIdToken.value.get.get

      val request = FakeRequest(PATCH, "/users/password")
          .withHeaders(
            ("Authorization", idToken)
          )
          .withJsonBody(
            generateTestCase("scalaTest@04")("scalaTest@04")
          )

      val response = route(app, request).get

      status(response) mustBe OK
      contentAsString(response) mustEqual "2"
    }

    "パスワードと確認用パスワードが不一致" in {

      val futureIdToken = getCustomToken(uid) |> getIdToken
      Await.ready(futureIdToken, Duration.Inf)
      val idToken = futureIdToken.value.get.get

      val request = FakeRequest(PATCH, "/users/password")
          .withHeaders(
            ("Authorization", idToken)
          )
          .withJsonBody(
            generateTestCase("scalaTest01")("scalaTest02")
          )

      val response = route(app, request).get

      status(response) mustBe BAD_REQUEST
      contentAsString(response) mustEqual Serialization.write(Map("message" -> "パスワードと確認用パスワードが不一致です"))
    }
  }

  "パスワードが8文字未満" in {

    val futureIdToken = getCustomToken(uid) |> getIdToken
    Await.ready(futureIdToken, Duration.Inf)
    val idToken = futureIdToken.value.get.get

    val request = FakeRequest(PATCH, "/users/password")
        .withHeaders(
          ("Authorization", idToken)
        )
        .withJsonBody(
          generateTestCase("scala09")("scala09")
        )

    val response = route(app, request).get

    status(response) mustBe BAD_REQUEST
    contentAsString(response) mustEqual Serialization.write(Map("message" -> "パスワードは8~32文字の半角英数字で指定してください"))
  }

  "パスワードが32文字より多い" in {

    val futureIdToken = getCustomToken(uid) |> getIdToken
    Await.ready(futureIdToken, Duration.Inf)
    val idToken = futureIdToken.value.get.get

    val request = FakeRequest(PATCH, "/users/password")
        .withHeaders(
          ("Authorization", idToken)
        )
        .withJsonBody(
          generateTestCase("scala0123456789scala0123456789scala")("scala0123456789scala0123456789scala")
        )

    val response = route(app, request).get

    status(response) mustBe BAD_REQUEST
    contentAsString(response) mustEqual Serialization.write(Map("message" -> "パスワードは8~32文字の半角英数字で指定してください"))
  }

  "パスワードが数字のみ" in {

    val futureIdToken = getCustomToken(uid) |> getIdToken
    Await.ready(futureIdToken, Duration.Inf)
    val idToken = futureIdToken.value.get.get

    val request = FakeRequest(PATCH, "/users/password")
        .withHeaders(
          ("Authorization", idToken)
        )
        .withJsonBody(
          generateTestCase("20201231")("20201231")
        )

    val response = route(app, request).get

    status(response) mustBe BAD_REQUEST
    contentAsString(response) mustEqual Serialization.write(Map("message" -> "パスワードは8~32文字の半角英数字で指定してください"))
  }

  "パスワードが英字のみ" in {

    val futureIdToken = getCustomToken(uid) |> getIdToken
    Await.ready(futureIdToken, Duration.Inf)
    val idToken = futureIdToken.value.get.get

    val request = FakeRequest(PATCH, "/users/password")
        .withHeaders(
          ("Authorization", idToken)
        )
        .withJsonBody(
          generateTestCase("scalaTest")("scalaTest")
        )

    val response = route(app, request).get

    status(response) mustBe BAD_REQUEST
    contentAsString(response) mustEqual Serialization.write(Map("message" -> "パスワードは8~32文字の半角英数字で指定してください"))
  }
}
