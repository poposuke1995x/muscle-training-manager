package usecase.TrainingMenu

import com.google.inject.Inject
import domain.TrainingMenuRepositoryInterface

import scala.concurrent.Future

case class DeleteTrainingMenuService @Inject()(repository: TrainingMenuRepositoryInterface) {
  def apply(id: Int): Future[Int] = repository.delete(id)

}
