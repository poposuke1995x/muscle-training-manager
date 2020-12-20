package controllers

import Utils.convertModelToResp
import com.google.inject.{Inject, Singleton}
import play.api.mvc._
import usecase.ShareLiftTypeService

import scala.concurrent.ExecutionContext

class ShareLiftTypeController @Inject()
(controllerComponents: ControllerComponents, shareLiftTypeService: ShareLiftTypeService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {


  def share(id: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    shareLiftTypeService(id).map(resp => Ok {
      convertModelToResp(("sharedLiftTypeId", resp))
    })
  }
}
