package usecase

import com.google.inject.{Inject, Singleton}
import domain.{LiftAction, UpdateTrainingActionRepositoryInterface}

import scala.concurrent.{ExecutionContext, Future}

@Singleton
case class UpdateTrainingActionService @Inject()
(repository: UpdateTrainingActionRepositoryInterface)(implicit executionContext: ExecutionContext) {
  def apply(actions: List[LiftAction]): Future[Int] = repository.execute(actions)
}