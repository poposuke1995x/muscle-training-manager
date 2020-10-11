package controllers

import domain._
import infrastructure.UserRepository
import javax.inject._
import org.json4s._
import org.json4s.native.{JsonMethods, Serialization}
import play.api.mvc._
import utils.Utils

import scala.concurrent.ExecutionContext

@Singleton
class UserController @Inject()
(controllerComponents: ControllerComponents, userRepository: UserRepository, util: Utils)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def index: Action[AnyContent] = Action.async {
    userRepository.index().map(users =>
      Ok(Serialization.write(users))
    )
  }

  def show: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    userRepository
      .findIdByUid(
        util.getFirebaseUid(request.headers.get("Authorization").getOrElse(""))
      )
      .map(users =>
        Ok(Serialization.write(users))
      )
  }

  def store: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    userRepository
      .insert(
        JsonMethods
          .parse(request.body.asJson.get.toString)
          .extract[User]
      )
      .map(resp => Ok(resp.toString))
  }

  def update: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    userRepository
      .update(
        JsonMethods
          .parse(request.body.asJson.get.toString)
          .extract[User]
      )
      .map(resp => Ok(resp.toString))
  }

  def delete(id: Option[Int]): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    userRepository
      .delete(id.get)
      .map(resp => Ok(resp.toString))
  }
}
