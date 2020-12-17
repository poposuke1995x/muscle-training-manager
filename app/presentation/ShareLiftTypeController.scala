package presentation

import com.google.inject.{Inject, Singleton}
import org.json4s.DefaultFormats
import play.api.mvc._
import usecase.ShareLiftTypeService

import scala.concurrent.ExecutionContext

@Singleton
class ShareLiftTypeController @Inject()
(controllerComponents: ControllerComponents, shareLiftTypeService: ShareLiftTypeService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def share(id: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    shareLiftTypeService(id).map { resp => Ok(resp.toString) }
  }
}
