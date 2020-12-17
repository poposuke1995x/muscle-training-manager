package usecase

import Utils.Pipeline
import com.google.inject.{Inject, Singleton}
import domain.{TrainingMenu, TrainingMenuRepositoryInterface}
import usecase.dto.TrainingMenuRequest

import scala.concurrent.Future

@Singleton
case class CreateTrainingMenuService @Inject()(repository: TrainingMenuRepositoryInterface) {
  def apply(trainingMenuReq: TrainingMenuRequest): Future[Int] =
    trainingMenuReq |> convertToEntity |> repository.insert

  def convertToEntity(trainingMenuReq: TrainingMenuRequest): TrainingMenu =
    TrainingMenu(
      id = trainingMenuReq.id,
      name = trainingMenuReq.name,
      description = trainingMenuReq.description,
      userId = trainingMenuReq.userId,
      shareFlag = trainingMenuReq.shareFlag
    )

}
