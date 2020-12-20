package controllers

import Utils.{convertModelToResp, convertReqToModel, responseError}
import com.google.inject.Inject
import domain.TrainingMenu
import play.api.mvc._
import usecase.CreateTrainingMenuService

import scala.concurrent.{ExecutionContext, Future}

class CreateTrainingMenuController @Inject()
(controllerComponents: ControllerComponents, createTrainingMenuService: CreateTrainingMenuService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  def store: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    convertReqToModel[TrainingMenu](request) match {
      case Some(value) => createTrainingMenuService(value).map {
        case Some(resp) => Ok {
          convertModelToResp(("createdTrainingMenuId", resp.toString))
        }
        case None => InternalServerError
      }
      case None => Future(BadRequest {
        responseError("BadRequest")
      })
    }
  }
}
