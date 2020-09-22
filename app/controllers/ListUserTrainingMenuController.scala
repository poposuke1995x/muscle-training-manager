package controllers

import javax.inject.{Inject, Singleton}
import org.json4s.DefaultFormats
import org.json4s.native.Serialization
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import usecase.TrainingMenu.{ListTrainingMenuService, ListUserTrainingMenuService}

import scala.concurrent.ExecutionContext

@Singleton
class ListUserTrainingMenuController @Inject()
(controllerComponents: ControllerComponents, listUserTrainingMenuService: ListUserTrainingMenuService)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def index(userId: Int, categoryId: Option[Int]): Action[AnyContent] = Action.async {
    listUserTrainingMenuService(userId, categoryId).map(trainingMenu =>
      Ok(Serialization.write(trainingMenu))
    )
  }
}
