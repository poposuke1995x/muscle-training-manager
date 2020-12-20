package controllers

import Utils.{Pipeline, convertModelToResp, getFirebaseUid, responseError}
import com.google.inject.Inject
import play.api.mvc.Results.Forbidden
import play.api.mvc._
import usecase.{ListUserLiftTypeService, UserService}

import scala.concurrent.{ExecutionContext, Future}

class ListUserLiftTypeController @Inject()
(
    controllerComponents: ControllerComponents,
    listUserLiftTypeService: ListUserLiftTypeService,
    userService: UserService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {


  def index: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    request |> getFirebaseUid match {
      case None => Future(Forbidden(responseError("Forbidden")))
      case Some(uid) =>
        uid |> userService.getUserId flatMap {
          case Some(userId) => listUserLiftTypeService(userId).map(resp => Ok(convertModelToResp(resp)))
          case None => Future {
            InternalServerError(responseError("InternalServerError"))
          }
        }
    }




    //    map {
    //      _ |> userService.getUserId map {
    //        _.map{
    //          listUserLiftTypeService(_).map { liftTypes => Ok(convertModelToResp(liftTypes)) }
    //        }
    //      }
    //    }
  }
}
