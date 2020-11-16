package controllers

import com.google.inject.Inject
import org.json4s.DefaultFormats
import org.json4s.native.Serialization
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import usecase.ListMenuLiftTypeService

import scala.concurrent.ExecutionContext

class ListMenuLiftTypeController @Inject()
(controllerComponents: ControllerComponents, listMenuLiftTypeService: ListMenuLiftTypeService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def index(trainingMenuId: Int, bodyPartId: Option[Int]): Action[AnyContent] = Action.async {
    listMenuLiftTypeService(trainingMenuId, bodyPartId).map { resp => Ok(Serialization.write(resp)) }
  }
}