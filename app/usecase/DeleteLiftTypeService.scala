package usecase

import com.google.inject.Inject
import domain.LiftTypeRepositoryInterface

import scala.concurrent.Future

case class DeleteLiftTypeService @Inject()(repository: LiftTypeRepositoryInterface) {
  def apply(id: Int): Future[Int] = repository.delete(id)

}
