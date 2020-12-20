package controllers

import Utils.convertModelToResp
import com.google.inject.Inject
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import usecase.ListLiftTypeService

import scala.concurrent.ExecutionContext

class ListLiftTypeController @Inject()
(controllerComponents: ControllerComponents, listLiftTypeService: ListLiftTypeService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {


  def index(bodyPartId: Option[Int]): Action[AnyContent] = Action.async {
    listLiftTypeService(bodyPartId).map { liftTypes => Ok(convertModelToResp(liftTypes)) }
  }
}
