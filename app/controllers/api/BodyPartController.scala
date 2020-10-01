package controllers.api

import domain._
import infrastructure.BodyPartRepository
import javax.inject._
import org.json4s._
import org.json4s.native.{JsonMethods, Serialization}
import play.api.mvc._
import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}

@Singleton
class BodyPartController @Inject()
(controllerComponents: ControllerComponents, bodyPartRepository: BodyPartRepository)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def index: Action[AnyContent] = Action.async {
    bodyPartRepository.index().map(bodyPart =>
      Ok(Serialization.write(bodyPart))
    )
  }

  def show(id: Int): Action[AnyContent] = Action.async {
    bodyPartRepository.findById(id).map(bodyPart =>
      Ok(Serialization.write(bodyPart))
    )
  }

  def store: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    bodyPartRepository
      .insert(
        JsonMethods
          .parse(request.body.asJson.get.toString)
          .extract[BodyPart]
      )
      .map(resp => Ok(resp.toString))
  }
//
//  def update(id: Int): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
//    val req = JsonMethods
//      .parse(request.body.asJson.get.toString)
//      .extract[Map[String, Any]]
//    bodyPartRepository.findById(id) onComplete {
//      case Success(value) => bodyPartRepository
//        .update(BodyPart(Some(id), req.getOrElse("name", value.name).toString))
//        .map(resp => Ok(resp.toString))
//      case Failure(exception) => Ok(exception.toString)
//    }
//    Ok("ok")
//  }

  //  def destroy(id: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
  //    bodyPartRepository
  //      .delete(id)
  //      .map(resp => Ok(resp.toString))
  //  }
}
