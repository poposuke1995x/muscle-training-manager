package controllers

import domain._
import infrastructure.LiftTypeRepository
import javax.inject._
import play.api.mvc._

import scala.concurrent.ExecutionContext
import org.json4s._
import org.json4s.native.JsonMethods
import org.json4s.native.Serialization
import usecase.LiftType.ListLiftTypeService

import scala.util.{Failure, Success, Try}

@Singleton
class LiftTypeController @Inject()
(controllerComponents: ControllerComponents, liftTypeRepository: LiftTypeRepository, listLiftTypeService: ListLiftTypeService)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def index: Action[AnyContent] = Action.async {
    listLiftTypeService().map(liftTypes =>
      Ok(Serialization.write(liftTypes))
    )
  }

  def show(id: Int): Action[AnyContent] = Action.async {
    liftTypeRepository.findById(id).map(liftTypes =>
      Ok(Serialization.write(liftTypes))
    )
  }

  def store: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    liftTypeRepository
      .insert(
        JsonMethods
          .parse(request.body.asJson.get.toString)
          .extract[LiftType]
      )
      .map(resp => Ok(resp.toString))
  }

  def update(id: Int): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val req = JsonMethods
      .parse(request.body.asJson.get.toString)
      .extract[Map[String, Any]]
    liftTypeRepository.findById(id) onComplete {
      case Success(value) => liftTypeRepository
        .update(LiftType(
          Some(id),
          req.getOrElse("name", value.name).toString,
          req.get("referenceUrl").flatMap(s => Try(s.toString).toOption),
          req.get("description").flatMap(s => Try(s.toString).toOption),
          req.getOrElse("importedCount", value.importedCount).toString.toInt,
          req.getOrElse("serverUid", value.serverUid).toString,
          req.getOrElse("defaultRep", value.defaultRep).toString.toInt,
          req.getOrElse("defaultWeight", value.defaultWeight).toString.toInt,
          req.getOrElse("defaultSetCount", value.defaultSetCount).toString.toInt,
          req.getOrElse("shareFlag", value.shareFlag).toString.toBoolean
        ))
        .map(resp => Ok(resp.toString))
      case Failure(exception) => Ok(exception.toString)
    }
    Ok("ok")
  }

//  def destroy(id: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
//    liftTypeRepository
//      .delete(id)
//      .map(resp => Ok(resp.toString))
//  }
}
