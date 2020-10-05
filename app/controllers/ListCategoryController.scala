package controllers

import com.google.inject._
import org.json4s._
import org.json4s.native.Serialization
import play.api.mvc._
import usecase.ListCategoryService

import scala.concurrent.ExecutionContext

@Singleton
class ListCategoryController @Inject()
(controllerComponents: ControllerComponents, listCategoryService: ListCategoryService)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def index: Action[AnyContent] = Action.async {
    listCategoryService().map(categories =>
      Ok(Serialization.write(categories))
    )
  }
}
