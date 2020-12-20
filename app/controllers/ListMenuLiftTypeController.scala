package controllers

import Utils.convertModelToResp
import com.google.inject.Inject
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import usecase.ListMenuLiftTypeService

import scala.concurrent.ExecutionContext

class ListMenuLiftTypeController @Inject()
(controllerComponents: ControllerComponents, listMenuLiftTypeService: ListMenuLiftTypeService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {


  def index(trainingMenuId: Int, bodyPartId: Option[Int]): Action[AnyContent] = Action.async {
    listMenuLiftTypeService(trainingMenuId, bodyPartId).map { menuLiftType => Ok(convertModelToResp(menuLiftType)) }
  }
}