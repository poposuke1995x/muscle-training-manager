package controllers

import com.google.inject.{Singleton, Inject}
import dto.LiftTypeRequest
import org.json4s.DefaultFormats
import org.json4s.native.JsonMethods
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents, Request}
import usecase.UpdateLiftTypeService

import scala.concurrent.ExecutionContext

@Singleton
class UpdateLiftTypeController @Inject()
(controllerComponents: ControllerComponents, updateLiftTypeService: UpdateLiftTypeService)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def update(liftTypeId: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    val liftTypeRequest = JsonMethods.parse(request.body.asJson.get.toString).extract[LiftTypeRequest]
    updateLiftTypeService(liftTypeId, liftTypeRequest).map(resp => Ok(resp.toString)
    )
  }
}
