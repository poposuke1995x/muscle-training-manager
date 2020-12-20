package controllers

import Utils.{convertModelToResp, convertReqToModel, responseError}
import com.google.inject.Inject
import play.api.mvc._
import usecase.RegisterLiftTypesToTrainingMenuService
import usecase.dto.TargetedLiftTypeRequest

import scala.concurrent.{ExecutionContext, Future}

class RegisterLiftTypesToTrainingMenuController @Inject()
(
    controllerComponents: ControllerComponents,
    registerLiftTypesToTrainingMenuService: RegisterLiftTypesToTrainingMenuService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {


  def registerLiftTypesToTrainingMenu(trainingMenuId: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    convertReqToModel[List[TargetedLiftTypeRequest]](request) match {
      case Some(value) =>
        registerLiftTypesToTrainingMenuService(trainingMenuId, value).map { resp => Ok(convertModelToResp(resp)) }
      case None => Future(BadRequest {
        responseError("BadRequest")
      })
    }

  }
}
