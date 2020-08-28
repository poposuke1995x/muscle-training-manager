package controllers.api

import infrastructure.CategoryRepository
import javax.inject._
import org.json4s._
import org.json4s.native.Serialization
import play.api.mvc._

import scala.concurrent.ExecutionContext

@Singleton
class CategoryController @Inject()
(controllerComponents: ControllerComponents, categoryRepository: CategoryRepository)
(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  implicit val formats: DefaultFormats.type = DefaultFormats

  def index: Action[AnyContent] = Action.async {
    categoryRepository.index().map(categories =>
      Ok(Serialization.write(categories))
    )
  }

  def show(category_id: Int): Action[AnyContent] = Action.async {
    categoryRepository.findById(category_id).map(categories =>
      Ok(Serialization.write(categories))
    )
  }
}
