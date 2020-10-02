package controllers

import com.google.inject.{Inject, Singleton}
import dto.TrainingMenuDetailRequest
import org.json4s.native.Serialization
import org.json4s.DefaultFormats
import org.json4s.native.JsonMethods
import play.api.mvc._
import usecase.UpdateTrainingMenuService
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UpdateTrainingMenuController @Inject()
(controllerComponents: ControllerComponents, updateTrainingMenuService: UpdateTrainingMenuService)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def update(trainingMenuId: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    (try {
      Some(JsonMethods.parse(request.body.asJson.get.toString).extract[TrainingMenuDetailRequest])
    } catch {
      case _: Any => None
    })
    match {
      case Some(value) =>
        if (value.name != null) {
          updateTrainingMenuService(trainingMenuId, value).map(resp => Ok(resp.toString))
        } else {
          Future(BadRequest(Serialization.write(Map("message" -> "bad request"))))
        }
      case None => Future(BadRequest(Serialization.write(Map("message" -> "bad request"))))
    }
  }
}
