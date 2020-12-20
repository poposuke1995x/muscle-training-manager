package controllers

import Utils.responseError
import com.google.inject.Inject
import play.api.mvc._
import usecase.DeleteLiftTypeService

import scala.concurrent.ExecutionContext

class DeleteLiftTypeController @Inject()
(controllerComponents: ControllerComponents, deleteLiftTypeService: DeleteLiftTypeService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {


  def delete(lift_type_id: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    deleteLiftTypeService(lift_type_id).map{
      case true => NoContent
      case false => InternalServerError{responseError("InternalServerError")}
    }
  }
}
