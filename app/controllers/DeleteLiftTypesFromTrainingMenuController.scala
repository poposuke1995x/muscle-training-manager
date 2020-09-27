package controllers

import javax.inject.{Inject, Singleton}
import org.json4s.DefaultFormats
import org.json4s.native.JsonMethods
import play.api.mvc._
import usecase.DeleteLiftTypesFromTrainingMenuService
import scala.concurrent.ExecutionContext

@Singleton
class DeleteLiftTypesFromTrainingMenuController @Inject()
(controllerComponents: ControllerComponents, deleteLiftTypesFromTrainingMenuService: DeleteLiftTypesFromTrainingMenuService)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def deleteLiftTypesFromTrainingMenu(trainingMenuId: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    deleteLiftTypesFromTrainingMenuService(trainingMenuId, JsonMethods
      .parse(request.body.asJson.get.toString)
      .extract[List[Int]]).map(resp => Ok(resp.toString))
  }
}
