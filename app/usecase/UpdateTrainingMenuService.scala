package usecase

import com.google.inject.{Inject, Singleton}
import domain.TrainingMenu
import domain.lifecycle.TrainingMenuRepositoryInterface
import usecase.dto.TrainingMenuDetailRequest

import scala.concurrent.{ExecutionContext, Future}

case class UpdateTrainingMenuService @Inject()
(repository: TrainingMenuRepositoryInterface)(implicit executionContext: ExecutionContext) {
  def apply(trainingMenuId: Int, trainingMenuDetailRequest: TrainingMenuDetailRequest): Future[Option[TrainingMenu]] =
    repository.findById(trainingMenuId).flatMap {
      case Some(value) => repository.update(genTrainingMenu(value: TrainingMenu, trainingMenuDetailRequest: TrainingMenuDetailRequest))
      case None => Future.successful(None)
    }


  def genTrainingMenu(
      origin: TrainingMenu,
      trainingMenuDetailRequest: TrainingMenuDetailRequest): TrainingMenu = TrainingMenu(
    id = origin.id,
    name = trainingMenuDetailRequest.name,
    description = Some(trainingMenuDetailRequest.description),
    userId = origin.userId,
    shareFlag = origin.shareFlag
  )
}
