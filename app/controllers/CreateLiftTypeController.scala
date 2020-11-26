package controllers

import domain.LiftType
import javax.inject.{Inject, Singleton}
import org.json4s.DefaultFormats
import org.json4s.native.{JsonMethods, Serialization}
import play.api.mvc._
import usecase.CreateLiftTypeService

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class CreateLiftTypeController @Inject()
(controllerComponents: ControllerComponents, createLiftTypeService: CreateLiftTypeService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def store: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    JsonMethods
        .parse(request.body.asJson.get.toString)
        .extractOpt[LiftType] match {
      case Some(value) => createLiftTypeService(value).map(resp => Ok(resp.toString))
      case None => Future(BadRequest(Serialization.write(Map("message" -> "bad request"))))
    }
  }
}
