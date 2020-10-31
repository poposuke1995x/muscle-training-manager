package usecase

import com.google.inject.{Inject, Singleton}
import domain.{TrainingMenu, TrainingMenuRepositoryInterface}
import dto.TrainingMenuDetailRequest
import scala.concurrent.{ExecutionContext, Future}

@Singleton
case class UpdateTrainingMenuService @Inject()
(repository: TrainingMenuRepositoryInterface)(implicit executionContext: ExecutionContext) {
  def apply(trainingMenuId: Int, trainingMenuDetailRequest: TrainingMenuDetailRequest): Future[Int] = for {
    origin <- repository.findById(trainingMenuId)
    result <- repository.update(genTrainingMenu(origin: TrainingMenu, trainingMenuDetailRequest: TrainingMenuDetailRequest))
  } yield result

  def genTrainingMenu(origin: TrainingMenu, trainingMenuDetailRequest: TrainingMenuDetailRequest): TrainingMenu = TrainingMenu(
    id = origin.id,
    name = trainingMenuDetailRequest.name,
    description = Some(trainingMenuDetailRequest.description),
    userId = origin.userId,
    shareFlag = origin.shareFlag
  )
}
