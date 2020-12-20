package usecase

import com.google.inject.Inject
import domain.lifecycle.LiftTypeRepositoryInterface

import scala.concurrent.Future

case class DeleteLiftTypeService @Inject()(repository: LiftTypeRepositoryInterface) {
  def apply(id: Int): Future[Boolean] = repository.delete(id)

}
