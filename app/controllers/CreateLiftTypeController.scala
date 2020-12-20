package controllers

import Utils.{convertModelToResp, convertReqToModel, responseError}
import com.google.inject.Inject
import domain.LiftType
import play.api.mvc._
import usecase.CreateLiftTypeService

import scala.concurrent.{ExecutionContext, Future}

class CreateLiftTypeController @Inject()
(controllerComponents: ControllerComponents,
    createLiftTypeService: CreateLiftTypeService
)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  def store: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    convertReqToModel[LiftType](request) match {
      case Some(value) => createLiftTypeService(value).map {
        case Some(resp) => Ok {
          convertModelToResp(resp)
        }
        case None => InternalServerError(responseError("InternalServerError"))
      }
      case None => Future {
        BadRequest(responseError("BadRequest"))
      }
    }
  }
}
