package controllers

import Utils.{Pipeline, getFirebaseUid}
import com.google.inject.Inject
import org.json4s.DefaultFormats
import org.json4s.native.Serialization
import play.api.mvc._
import usecase.{ListTrainingMenuService, UserService}

import scala.concurrent.{ExecutionContext, Future}

class ListTrainingMenuController @Inject()
(
    controllerComponents: ControllerComponents,
    listTrainingMenuService: ListTrainingMenuService,
    userService: UserService
)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats


  def index: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>

    request |> getFirebaseUid match {
      case None => Future(Ok)
      case Some(uid) => uid |> userService.getUserId flatMap {
        case Some(userId) => listTrainingMenuService(userId).map { trainingMenu => Ok(Serialization.write(trainingMenu)) }
        case None => Future(Ok)
      }
    }


  }
}
