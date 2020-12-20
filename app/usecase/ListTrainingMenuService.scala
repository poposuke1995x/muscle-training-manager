package usecase

import com.google.inject.{Inject, Singleton}
import domain.TrainingMenu
import domain.lifecycle.TrainingMenuRepositoryInterface

import scala.concurrent.Future

case class ListTrainingMenuService @Inject()(repository: TrainingMenuRepositoryInterface) {
  def apply(userId: Int): Future[Seq[TrainingMenu]] = repository.findByUserId(userId)
}
