package controllers

import javax.inject.{Inject, Singleton}
import org.json4s.DefaultFormats
import org.json4s.native.{JsonMethods, Serialization}
import play.api.mvc._
import usecase.DeleteLiftTypesFromTrainingMenuService

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class DeleteLiftTypesFromTrainingMenuController @Inject()
(controllerComponents: ControllerComponents, deleteLiftTypesFromTrainingMenuService: DeleteLiftTypesFromTrainingMenuService)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def deleteLiftTypesFromTrainingMenu(trainingMenuId: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    JsonMethods
      .parse(request.body.asJson.get.toString)
      .extractOpt[List[Int]] match {
      case Some(value) => deleteLiftTypesFromTrainingMenuService(trainingMenuId, value).map(resp => Ok(resp.toString))
      case None => Future(BadRequest(Serialization.write(Map("message" -> "bad request"))))
    }


  }
}
