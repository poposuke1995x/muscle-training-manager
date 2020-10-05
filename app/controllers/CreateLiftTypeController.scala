package controllers

import domain.LiftType
import javax.inject.{Inject, Singleton}
import org.json4s.DefaultFormats
import org.json4s.native.JsonMethods
import play.api.mvc._
import usecase.CreateLiftTypeService
import scala.concurrent.ExecutionContext

@Singleton
class CreateLiftTypeController @Inject()
(controllerComponents: ControllerComponents, createLiftTypeService: CreateLiftTypeService)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def store: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    createLiftTypeService(
      JsonMethods
        .parse(request.body.asJson.get.toString)
        .extract[LiftType]
    ).map(resp => Ok(resp.toString))
  }
}
