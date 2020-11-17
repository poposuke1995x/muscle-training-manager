package controllers

import com.google.inject.Inject
import org.json4s.DefaultFormats
import org.json4s.native.Serialization
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import usecase.GetLiftTypeService
import scala.concurrent.ExecutionContext

class GetLiftTypeController @Inject()
(controllerComponents: ControllerComponents, getLiftTypeService: GetLiftTypeService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def show(liftTypeId: Int): Action[AnyContent] = Action.async {
    getLiftTypeService(liftTypeId).map { liftType => Ok(Serialization.write(liftType)) }
  }
}
