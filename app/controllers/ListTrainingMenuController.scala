package controllers

import com.google.inject.{Inject, Singleton}
import org.json4s.DefaultFormats
import org.json4s.native.Serialization
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import usecase.ListTrainingMenuService

import scala.concurrent.ExecutionContext

@Singleton
class ListTrainingMenuController @Inject()
(controllerComponents: ControllerComponents, listTrainingMenuService: ListTrainingMenuService)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def index: Action[AnyContent] = Action.async {
    listTrainingMenuService().map(trainingMenu =>
      Ok(Serialization.write(trainingMenu))
    )
  }
}
