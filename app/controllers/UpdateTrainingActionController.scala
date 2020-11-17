package controllers

import com.google.inject.{Inject, Singleton}
import domain.LiftAction
import dto.MenuLiftActionRequest
import org.json4s.DefaultFormats
import org.json4s.native.{JsonMethods, Serialization}
import play.api.mvc._
import usecase.UpdateTrainingActionService

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UpdateTrainingActionController @Inject()
(controllerComponents: ControllerComponents, updateTrainingActionService: UpdateTrainingActionService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def update(trainingMenuId: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    JsonMethods
        .parse(request.body.asJson.get.toString)
        .extractOpt[List[MenuLiftActionRequest]] match {
      case Some(value) => updateTrainingActionService(value).map { resp => Ok(resp.toString) }
      case None => Future(BadRequest(Serialization.write(Map("message" -> "bad request"))))
    }
  }
}
