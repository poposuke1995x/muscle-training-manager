package controllers.api

import domain._
import infrastructure.TargetRepository
import javax.inject._
import org.json4s._
import org.json4s.native.{JsonMethods, Serialization}
import play.api.mvc._

import scala.concurrent.ExecutionContext

@Singleton
class TargetController @Inject()
(controllerComponents: ControllerComponents, targetRepository: TargetRepository)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def index: Action[AnyContent] = Action.async {
    targetRepository.index().map(bodyPart =>
      Ok(Serialization.write(bodyPart))
    )
  }

  def show(id: Int): Action[AnyContent] = Action.async {
    targetRepository.findById(id).map(bodyPart =>
      Ok(Serialization.write(bodyPart))
    )
  }

  def store: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    targetRepository
      .insert(
        JsonMethods
          .parse(request.body.asJson.get.toString)
          .extract[Target]
      )
      .map(resp => Ok(resp.toString))
  }

  def update(id: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    val req = JsonMethods
      .parse(request.body.asJson.get.toString)
      .extract[Map[String, Boolean]]
    targetRepository
      .updateIsMain(id, req("isMain"))
      .map(resp => Ok(resp.toString))
  }

  //  def destroy(id: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
  //    targetRepository
  //      .delete(id)
  //      .map(resp => Ok(resp.toString))
  //  }
}
