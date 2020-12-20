package controllers

import Utils.{convertModelToResp, convertReqToModel, responseError}
import com.google.inject.Inject
import play.api.mvc._
import usecase.UpdateTrainingMenuService
import usecase.dto.TrainingMenuDetailRequest

import java.util.Objects.isNull
import scala.concurrent.{ExecutionContext, Future}

class UpdateTrainingMenuController @Inject()
(controllerComponents: ControllerComponents, updateTrainingMenuService: UpdateTrainingMenuService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  def update(trainingMenuId: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    convertReqToModel[TrainingMenuDetailRequest] (request)match {
      case Some(value) if !isNull(value.name) =>
        updateTrainingMenuService(trainingMenuId, value).map {
          case Some(value) => Ok(convertModelToResp(value))
          case None => InternalServerError(responseError("InternalServerError"))
        }
      case None => Future(BadRequest(responseError("BadRequest")))
    }
  }
}
