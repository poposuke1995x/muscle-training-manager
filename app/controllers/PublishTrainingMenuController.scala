package controllers

import domain.TrainingMenu
import javax.inject.{Inject, Singleton}
import org.json4s.DefaultFormats
import org.json4s.native.JsonMethods
import play.api.mvc._
import usecase.TrainingMenu.PublishTrainingMenuService

import scala.concurrent.ExecutionContext

@Singleton
class PublishTrainingMenuController @Inject()
(controllerComponents: ControllerComponents, publishTrainingMenuService: PublishTrainingMenuService)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def publish(id: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    publishTrainingMenuService(id).map(resp => Ok(resp.toString))
  }
}
