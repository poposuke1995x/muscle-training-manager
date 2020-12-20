package usecase

import com.google.inject.{Inject, Singleton}
import domain.LiftType
import domain.lifecycle.LiftTypeRepositoryInterface

import scala.concurrent.Future

case class CreateLiftTypeService @Inject()(repository: LiftTypeRepositoryInterface) {
  def apply(liftType: LiftType): Future[Option[LiftType]] = repository.insert(liftType)

}
