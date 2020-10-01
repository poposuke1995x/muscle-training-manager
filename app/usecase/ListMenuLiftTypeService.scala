package usecase

import com.google.inject.Inject
import domain.{LiftType, ListMenuLiftTypeRepositoryInterface}

import scala.concurrent.{ExecutionContext, Future}

case class ListMenuLiftTypeService @Inject()(repository: ListMenuLiftTypeRepositoryInterface)(implicit executionContext: ExecutionContext) {
  def apply(trainingMenuId: Int, bodyPartId: Option[Int]): Future[Seq[LiftType]] = repository.execute(trainingMenuId: Int, bodyPartId: Option[Int])
}
