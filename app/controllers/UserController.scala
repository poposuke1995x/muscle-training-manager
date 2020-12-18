package controllers

import Utils.{Pipeline, getFirebaseUid, updateFirebasePassword}
import com.google.inject.Inject
import dto.UpdatePasswordRequest
import org.json4s._
import org.json4s.native.{JsonMethods, Serialization}
import play.api.mvc._
import usecase.UserService

import scala.concurrent.{ExecutionContext, Future}

class UserController @Inject()
(controllerComponents: ControllerComponents, userService: UserService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def show: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    (request.headers.get("Authorization").getOrElse("")
        |> getFirebaseUid
        |> userService.getUserId)
        .map { userId => Ok(Serialization.write(userId)) }
  }

  def updatePassword(): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>

    JsonMethods
        .parse(request.body.asJson.get.toString)
        .extractOpt[UpdatePasswordRequest] match {
      case Some(updateReq) =>
        updateReq.validate match {
          case Right(newPassword) =>
            val uid = request.headers.get("Authorization").getOrElse("") |> getFirebaseUid
            (updateFirebasePassword(uid)(newPassword) |> userService.getUserId)
                .map { userId => Ok(Serialization.write(userId)) }
          case Left(errMessage) => Future(BadRequest(Serialization.write(Map("message" -> errMessage))))
        }
      case None => Future(BadRequest(Serialization.write(Map("message" -> "リクエスト内容に誤りがあります"))))
    }

  }
}
