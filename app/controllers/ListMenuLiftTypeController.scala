package controllers

import com.google.inject.Inject
import dto.ListMenuLiftTypeRequest
import org.json4s.DefaultFormats
import org.json4s.native.{JsonMethods, Serialization}
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents, Request}
import usecase.ListMenuLiftTypeService

import scala.concurrent.ExecutionContext

class ListMenuLiftTypeController @Inject()
(controllerComponents: ControllerComponents, listMenuLiftTypeService: ListMenuLiftTypeService)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def index(trainingMenuId: Int, bodyPartId: Option[Int]): Action[AnyContent] = Action.async {
    listMenuLiftTypeService(
      trainingMenuId, bodyPartId).map(liftTypes => Ok(Serialization.write(liftTypes))
    )
  }
}