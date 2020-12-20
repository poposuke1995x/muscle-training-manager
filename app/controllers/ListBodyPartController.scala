package controllers

import Utils.convertModelToResp
import com.google.inject.Inject
import play.api.mvc._
import usecase.ListBodyPartService

import scala.concurrent.ExecutionContext

class ListBodyPartController @Inject()
(controllerComponents: ControllerComponents, listBodyPartService: ListBodyPartService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  def index: Action[AnyContent] = Action.async {
    listBodyPartService().map { bodyParts => Ok(convertModelToResp(bodyParts)) }
  }
}
