package controllers

import Utils.{convertModelToResp, convertReqToModel}
import com.google.inject.Inject
import play.api.mvc._
import usecase.UpdateTrainingActionService
import usecase.dto.MenuLiftActionRequest

import scala.concurrent.{ExecutionContext, Future}

class UpdateTrainingActionController @Inject()
(controllerComponents: ControllerComponents, updateTrainingActionService: UpdateTrainingActionService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {


  def update(trainingMenuId: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    convertReqToModel[List[MenuLiftActionRequest]](request) match {
      case Some(value) => updateTrainingActionService(value).map {
        case Some(v) => Ok(convertModelToResp(v))
        case None => InternalServerError("InternalServerError")
      }
      case None => Future(BadRequest("BadRequest"))
    }
  }
}
