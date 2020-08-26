package usecase.LiftType

import com.google.inject.{Inject, Singleton}
import domain.{LiftType, LiftTypeRepositoryInterface}

import scala.concurrent.Future

@Singleton
case class ListLiftTypeService @Inject() (repository: LiftTypeRepositoryInterface) {
  def apply(): Future[Seq[LiftType]] = repository.index()
}
