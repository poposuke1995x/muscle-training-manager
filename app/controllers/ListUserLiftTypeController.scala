package controllers

import Utils.{Pipeline, getFirebaseUid}
import com.google.inject.{Inject, Singleton}
import org.json4s.DefaultFormats
import org.json4s.native.Serialization
import play.api.mvc._
import usecase.{ListUserLiftTypeService, UserService}

import scala.concurrent.ExecutionContext

@Singleton
class ListUserLiftTypeController @Inject()
(
    controllerComponents: ControllerComponents,
    listUserLiftTypeService: ListUserLiftTypeService,
    userService: UserService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def index: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    (request.headers.get("Authorization").getOrElse("")
        |> getFirebaseUid
        |> userService.getUserId)
        .flatMap {
          userId => listUserLiftTypeService(userId).map { liftTypes => Ok(Serialization.write(liftTypes)) }
        }
  }
}
