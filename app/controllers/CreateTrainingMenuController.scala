package controllers

import domain.{BodyPart, TrainingMenu}
import javax.inject.{Inject, Singleton}
import org.json4s.DefaultFormats
import org.json4s.native.{JsonMethods, Serialization}
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents, Request}
import usecase.TrainingMenu.{CreateTrainingMenuService, ListTrainingMenuService}

import scala.concurrent.ExecutionContext

@Singleton
class CreateTrainingMenuController @Inject()
(controllerComponents: ControllerComponents, createTrainingMenuService: CreateTrainingMenuService)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def store: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    createTrainingMenuService(
      JsonMethods
        .parse(request.body.asJson.get.toString)
        .extract[TrainingMenu]
    ).map(resp => Ok(resp.toString))
  }
}
