package controllers

import javax.inject.{Inject, Singleton}
import org.json4s.DefaultFormats
import org.json4s.native.Serialization
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import usecase.LiftType.{ListLiftTypeService, ListUserLiftTypeService}

import scala.concurrent.ExecutionContext

@Singleton
class ListUserLiftTypeController @Inject()
(controllerComponents: ControllerComponents, listUserLiftTypeService: ListUserLiftTypeService)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def index(userId: Int): Action[AnyContent] = Action.async {
    listUserLiftTypeService(userId).map(liftTypes =>
      Ok(Serialization.write(liftTypes))
    )
  }
}
