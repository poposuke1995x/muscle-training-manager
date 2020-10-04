package controllers

import infrastructure.BodyPartRepository
import javax.inject._
import org.json4s._
import org.json4s.native.Serialization
import play.api.mvc._

import scala.concurrent.ExecutionContext

@Singleton
class ListBodyPartController @Inject()
(controllerComponents: ControllerComponents, bodyPartRepository: BodyPartRepository)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def index: Action[AnyContent] = Action.async {
    bodyPartRepository.index().map(bodyPart =>
      Ok(Serialization.write(bodyPart))
    )
  }
}
