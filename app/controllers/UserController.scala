package controllers

import Utils.{Pipeline, getFirebaseUid}
import javax.inject._
import org.json4s._
import org.json4s.native.Serialization
import play.api.mvc._
import usecase.UserService

import scala.concurrent.ExecutionContext

@Singleton
class UserController @Inject()
(controllerComponents: ControllerComponents, userService: UserService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def show: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    (request.headers.get("Authorization").getOrElse("")
        |> getFirebaseUid
        |> userService.getUserId)
        .map { userId => Ok(Serialization.write(userId)) }
  }
}
