package controllers

import Utils.{convertReqToModel, responseError}
import com.google.inject.Inject
import org.json4s.DefaultFormats
import play.api.mvc._
import usecase.DeleteLiftTypesFromTrainingMenuService

import scala.concurrent.{ExecutionContext, Future}

class DeleteLiftTypesFromTrainingMenuController @Inject()
(
    controllerComponents: ControllerComponents,
    deleteLiftTypesFromTrainingMenuService: DeleteLiftTypesFromTrainingMenuService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def deleteLiftTypesFromTrainingMenu(trainingMenuId: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    convertReqToModel[List[Int]](request) match {
      case None => Future(BadRequest {responseError("BadRequest")})
      case Some(value) => deleteLiftTypesFromTrainingMenuService(trainingMenuId, value).map{
        case true => NoContent
        case false =>  InternalServerError{responseError("InternalServerError")}
      }
    }
  }
}
