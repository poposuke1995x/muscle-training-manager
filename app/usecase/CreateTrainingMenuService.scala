package usecase

import com.google.inject.{Inject, Singleton}
import domain.TrainingMenu
import domain.lifecycle.TrainingMenuRepositoryInterface

import scala.concurrent.Future

case class CreateTrainingMenuService @Inject()(repository: TrainingMenuRepositoryInterface) {
  def apply(trainingMenu: TrainingMenu): Future[Option[TrainingMenu]] = repository.insert(trainingMenu)
}
