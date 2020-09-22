package usecase.TrainingMenu

import com.google.inject.{Inject, Singleton}
import domain.{TrainingMenu, TrainingMenuRepositoryInterface}

import scala.concurrent.Future

@Singleton
case class ListUserTrainingMenuService @Inject()(repository: TrainingMenuRepositoryInterface) {
  def apply(userId: Int, categoryId: Option[Int]): Future[Seq[TrainingMenu]] = repository.findByUserId(userId, categoryId)
}
