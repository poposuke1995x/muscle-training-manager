package controllers

import com.google.inject.{Inject, Singleton}
import org.json4s._
import org.json4s.native.Serialization
import play.api.mvc._
import usecase.ListBodyPartService

import scala.concurrent.ExecutionContext

@Singleton
class ListBodyPartController @Inject()
(controllerComponents: ControllerComponents, listBodyPartService: ListBodyPartService)
    (implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def index: Action[AnyContent] = Action.async {
    listBodyPartService().map { bodyParts => Ok(Serialization.write(bodyParts)) }
  }
}
