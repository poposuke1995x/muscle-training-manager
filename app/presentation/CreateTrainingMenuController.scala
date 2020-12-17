package presentation

import domain.TrainingMenu

import javax.inject.{Inject, Singleton}
import org.json4s.DefaultFormats
import org.json4s.native.{JsonMethods, Serialization}
import play.api.mvc._
import usecase.CreateTrainingMenuService
import usecase.dto.TrainingMenuRequest

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class CreateTrainingMenuController @Inject()
(controllerComponents: ControllerComponents, createTrainingMenuService: CreateTrainingMenuService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {
  implicit val formats: DefaultFormats.type = DefaultFormats

  def store: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    JsonMethods
        .parse(request.body.asJson.get.toString)
        .extractOpt[TrainingMenuRequest] match {
      case Some(value) => createTrainingMenuService(value).map(resp => Ok(resp.toString))
      case None => Future(BadRequest(Serialization.write(Map("message" -> "bad request"))))
    }
  }
}
