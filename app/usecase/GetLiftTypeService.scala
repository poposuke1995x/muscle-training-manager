package usecase

import com.google.inject.Inject
import domain.LiftType
import domain.lifecycle.LiftTypeRepositoryInterface

import scala.concurrent.Future

case class GetLiftTypeService @Inject() (repository: LiftTypeRepositoryInterface) {
  def apply(liftTypeId: Int): Future[Option[LiftType]] = repository.findById(liftTypeId)
}
