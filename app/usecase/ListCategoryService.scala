package usecase

import com.google.inject.Inject
import domain.Category
import domain.lifecycle.CategoryRepositoryInterface

import scala.concurrent.Future

case class ListCategoryService @Inject()(repository: CategoryRepositoryInterface) {
  def apply(): Future[List[Category]] = repository.index()
}
