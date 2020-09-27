package usecase

import com.google.inject.{Inject, Singleton}
import domain.{TrainingMenu, TrainingMenuRepositoryInterface}

import scala.concurrent.Future

@Singleton
case class CreateTrainingMenuService @Inject()(repository: TrainingMenuRepositoryInterface) {
  def apply(trainingMenu: TrainingMenu): Future[Int] = repository.insert(trainingMenu)
}
