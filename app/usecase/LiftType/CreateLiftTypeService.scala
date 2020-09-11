package usecase.LiftType

import com.google.inject.{Inject, Singleton}
import domain.{LiftType, LiftTypeRepositoryInterface}

import scala.concurrent.Future

@Singleton
case class CreateLiftTypeService @Inject()(repository: LiftTypeRepositoryInterface)  {
  def apply(liftType: LiftType): Future[Int] = {
    repository.insert(liftType)
  }
}
