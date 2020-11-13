package usecase

import com.google.inject.{Inject, Singleton}
import domain.{TrainingMenu, TrainingMenuRepositoryInterface}

import scala.concurrent.Future

@Singleton
case class ListTrainingMenuService @Inject()(repository: TrainingMenuRepositoryInterface) {
  def apply(userId: Int): Future[Seq[TrainingMenu]] = repository.findByUserId(userId)
}
