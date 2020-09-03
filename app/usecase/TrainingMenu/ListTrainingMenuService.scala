package usecase.TrainingMenu

import com.google.inject.{Inject, Singleton}
import domain.{TrainingMenu, TrainingMenuRepositoryInterface}

import scala.concurrent.Future

@Singleton
case class ListTrainingMenuService @Inject() (repository: TrainingMenuRepositoryInterface) {
  def apply(): Future[Seq[TrainingMenu]] = repository.index()
}
