package controllers

import Utils.convertModelToResp
import com.google.inject.Inject
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import usecase.GetLiftTypeService

import scala.concurrent.ExecutionContext

class GetLiftTypeController @Inject()
(controllerComponents: ControllerComponents, getLiftTypeService: GetLiftTypeService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {


  def show(liftTypeId: Int): Action[AnyContent] = Action.async {
    getLiftTypeService(liftTypeId).map {
      case Some(liftType) => Ok(convertModelToResp(liftType))
      case None => NotFound
    }
  }
}
