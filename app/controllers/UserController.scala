package controllers

import domain._
import infrastructure.UserRepository
import javax.inject._
import org.json4s._
import org.json4s.native.{JsonMethods, Serialization}
import play.api.mvc._
import usecase.CreateUserService
import utils.Utils
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UserController @Inject()
(controllerComponents: ControllerComponents, createUerService: CreateUserService, userRepository: UserRepository, util: Utils)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

//  def index: Action[AnyContent] = Action.async {
//    userRepository.index().map(users =>
//      Ok(Serialization.write(users))
//    )
//  }

  def show: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    util.getUserId(
      util.getFirebaseUid(request.headers.get("Authorization").getOrElse(""))
    ).map(userId =>
      Ok(Serialization.write(userId))
    )
  }

//  def store: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
//    util.getUserId(request.headers.get("Authorization").getOrElse(""))
//    match {
//      case id if id.value.get == 0 => Future(Forbidden("existing user"))
//      case _ => createUerService(
//        JsonMethods
//          .parse(request.body.asJson.get.toString)
//          .extract[User])
//        .map(resp => Ok(resp.toString))
//    }
//  }

//  def update: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
//    userRepository
//      .update(
//        JsonMethods
//          .parse(request.body.asJson.get.toString)
//          .extract[User]
//      )
//      .map(resp => Ok(resp.toString))
//  }
}
