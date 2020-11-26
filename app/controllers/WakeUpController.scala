package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}

@Singleton
class WakeUpController @Inject()
(controllerComponents: ControllerComponents) extends AbstractController(controllerComponents) {

  def index: Action[AnyContent] = Action(Ok)
}
