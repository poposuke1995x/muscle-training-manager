package controllers

import domain.BodyPart
import dto.RegisterLiftTypesToTrainingMenuRequest
import javax.inject.{Inject, Singleton}
import org.json4s.DefaultFormats
import org.json4s.native.{JsonMethods, Serialization}
import play.api.mvc._
import usecase.RegisterLiftTypesToTrainingMenuService

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

@Singleton
class RegisterLiftTypesToTrainingMenuController @Inject()
(controllerComponents: ControllerComponents, registerLiftTypesToTrainingMenuService: RegisterLiftTypesToTrainingMenuService)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def registerLiftTypesToTrainingMenu: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    Future.sequence(
      registerLiftTypesToTrainingMenuService(
        JsonMethods
          .parse(request.body.asJson.get.toString)
          .extract[RegisterLiftTypesToTrainingMenuRequest]
      )
    ).map(resp => Ok(Serialization.write(resp)))
  }
}
