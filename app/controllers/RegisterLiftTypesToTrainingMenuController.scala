package controllers

import dto.RegisterLiftTypesToTrainingMenuRequest
import com.google.inject.{Inject, Singleton}
import org.json4s.DefaultFormats
import org.json4s.native.{JsonMethods, Serialization}
import play.api.mvc._
import usecase.RegisterLiftTypesToTrainingMenuService
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class RegisterLiftTypesToTrainingMenuController @Inject()
(controllerComponents: ControllerComponents, registerLiftTypesToTrainingMenuService: RegisterLiftTypesToTrainingMenuService)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def registerLiftTypesToTrainingMenu(trainingMenuId: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    Future.sequence(
      registerLiftTypesToTrainingMenuService(
        trainingMenuId,
        JsonMethods
          .parse(request.body.asJson.get.toString)
          .extract[RegisterLiftTypesToTrainingMenuRequest]
      )
    ).map(resp => Ok(Serialization.write(resp)))
  }
}
