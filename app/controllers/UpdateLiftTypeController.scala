package controllers

import Utils.{convertModelToResp, convertReqToModel, responseError}
import com.google.inject.Inject
import play.api.mvc._
import usecase.UpdateLiftTypeService
import usecase.dto.LiftTypeRequest

import scala.concurrent.{ExecutionContext, Future}

class UpdateLiftTypeController @Inject()
(controllerComponents: ControllerComponents, updateLiftTypeService: UpdateLiftTypeService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {


  def update(liftTypeId: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    convertReqToModel[LiftTypeRequest](request) match {
      case Some(value) => updateLiftTypeService(liftTypeId, value).map {
        case Some(value) => Ok(convertModelToResp(value))
        case None => InternalServerError(responseError("InternalServerError"))
      }
      case None => Future(BadRequest {
        responseError("BadRequest")
      })
    }
  }
}
