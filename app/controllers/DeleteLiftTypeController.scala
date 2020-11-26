package controllers

import javax.inject.{Inject, Singleton}
import org.json4s.DefaultFormats
import play.api.mvc._
import usecase.DeleteLiftTypeService
import scala.concurrent.ExecutionContext

@Singleton
class DeleteLiftTypeController @Inject()
(controllerComponents: ControllerComponents, deleteLiftTypeService: DeleteLiftTypeService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def delete(lift_type_id: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    deleteLiftTypeService(lift_type_id).map(resp => Ok(resp.toString))
  }
}
