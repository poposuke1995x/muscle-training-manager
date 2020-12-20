package controllers

import Utils.responseError
import com.google.inject.Inject
import play.api.mvc._
import usecase.DeleteTrainingMenuService

import scala.concurrent.ExecutionContext

class DeleteTrainingMenuController @Inject()
(controllerComponents: ControllerComponents, deleteTrainingMenuService: DeleteTrainingMenuService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {


  def delete(trainingMenuId: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    deleteTrainingMenuService(trainingMenuId).map{
      case true => NoContent
      case false => InternalServerError{responseError("InternalServerError")}
    }
  }
}
