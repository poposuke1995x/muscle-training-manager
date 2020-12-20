package usecase

import com.google.inject.Inject
import domain.lifecycle.TrainingMenuRepositoryInterface

import scala.concurrent.Future

case class DeleteTrainingMenuService @Inject()(repository: TrainingMenuRepositoryInterface) {
  def apply(id: Int): Future[Boolean] = repository.delete(id)

}
