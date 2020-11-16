package controllers

import Utils.{Pipeline, getFirebaseUid}
import com.google.inject.{Inject, Singleton}
import org.json4s.DefaultFormats
import org.json4s.native.Serialization
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents, Request}
import usecase.{ListTrainingMenuService, UserService}

import scala.concurrent.ExecutionContext

@Singleton
class ListTrainingMenuController @Inject()
(
    controllerComponents: ControllerComponents,
    listTrainingMenuService: ListTrainingMenuService,
    userService: UserService
)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats


  def index: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>

    (request.headers.get("Authorization").getOrElse("")
        |> getFirebaseUid
        |> userService.getUserId)
        .flatMap {
          listTrainingMenuService(_).map { trainingMenu => Ok(Serialization.write(trainingMenu)) }
        }
  }
}
