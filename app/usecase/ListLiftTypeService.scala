package usecase

import com.google.inject.{Inject, Singleton}
import domain.LiftType
import domain.lifecycle.ListLiftTypeRepositoryInterface

import scala.concurrent.Future

case class ListLiftTypeService @Inject()(repository: ListLiftTypeRepositoryInterface) {
  def apply(bodyPartId: Option[Int]): Future[Seq[LiftType]] = repository.execute(bodyPartId)
}
