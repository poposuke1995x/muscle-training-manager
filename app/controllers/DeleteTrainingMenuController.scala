package controllers

import javax.inject.{Inject, Singleton}
import org.json4s.DefaultFormats
import play.api.mvc._
import usecase.DeleteTrainingMenuService
import scala.concurrent.ExecutionContext

@Singleton
class DeleteTrainingMenuController @Inject()
(controllerComponents: ControllerComponents, deleteTrainingMenuService: DeleteTrainingMenuService)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def delete(trainingMenuId: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    deleteTrainingMenuService(trainingMenuId)
      .map(resp => Ok(resp.toString))
  }
}
