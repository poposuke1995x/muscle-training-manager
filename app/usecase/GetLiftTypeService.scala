package usecase

import com.google.inject.Inject
import domain.{LiftType, LiftTypeRepositoryInterface}

import scala.concurrent.Future

case class GetLiftTypeService @Inject() (repository: LiftTypeRepositoryInterface) {
  def apply(liftTypeId: Int): Future[LiftType] = repository.findById(liftTypeId)
}
