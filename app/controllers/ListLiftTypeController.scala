package controllers

import com.google.inject.{Inject, Singleton}
import org.json4s.DefaultFormats
import org.json4s.native.Serialization
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import usecase.ListLiftTypeService
import scala.concurrent.ExecutionContext

@Singleton
class ListLiftTypeController @Inject()
(controllerComponents: ControllerComponents, listLiftTypeService: ListLiftTypeService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def index(bodyPartId: Option[Int]): Action[AnyContent] = Action.async {
    listLiftTypeService(bodyPartId).map { liftTypes => Ok(Serialization.write(liftTypes)) }
  }
}
