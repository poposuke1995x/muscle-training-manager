package controllers

import Utils.{Pipeline, convertModelToResp, convertReqToModel, getFirebaseUid, responseError, updateFirebasePassword}
import com.google.inject.Inject
import play.api.mvc._
import usecase.UserService
import usecase.dto.UpdatePasswordRequest

import scala.concurrent.{ExecutionContext, Future}

class UpdatePasswordController @Inject()
(controllerComponents: ControllerComponents, userService: UserService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  def execute(): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    request |> getFirebaseUid match {
      case None => Future(Forbidden(responseError("Forbidden")))
      case Some(uid) => convertReqToModel[UpdatePasswordRequest](request) match {
        case None => Future(BadRequest(responseError("BadRequest")))
        case Some(updateReq) => updateReq.validate match {
          case Left(errMessage) => Future(BadRequest(convertModelToResp(("message", errMessage))))
          case Right(newPassword) => update(uid)(newPassword) match {
            case None => Future(InternalServerError(responseError("InternalServerError")))
            case Some(value) => value
          }
        }
      }
    }
  }

  def update(uid: String)(newPassword: String): Option[Future[Result]] =
    updateFirebasePassword(uid)(newPassword).map(_ |> userService.getUserId map {
      case None => InternalServerError(responseError("InternalServerError"))
      case Some(userId) => Ok {
        convertModelToResp(("userId", userId.toString))
      }
    })
}
