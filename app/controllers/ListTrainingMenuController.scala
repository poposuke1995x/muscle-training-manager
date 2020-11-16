package controllers

import com.google.inject.{Inject, Singleton}
import org.json4s.DefaultFormats
import org.json4s.native.Serialization
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents, Request}
import usecase.ListTrainingMenuService
import utils.Utils

import scala.concurrent.ExecutionContext

@Singleton
class ListTrainingMenuController @Inject()
(
    controllerComponents: ControllerComponents,
    listTrainingMenuService: ListTrainingMenuService,
    utils: Utils
)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats


  def index: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    implicit def Pipeline[T](x: T): utils.Pipeline[T] = utils.Pipeline(x)

    (request.headers.get("Authorization").getOrElse("")
        |> utils.getFirebaseUid
        |> utils.getUserId)
        .flatMap { userId =>
          listTrainingMenuService(userId)
              .map { trainingMenu => Ok(Serialization.write(trainingMenu)) }
        }
  }
}
