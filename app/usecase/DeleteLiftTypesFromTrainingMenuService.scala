package usecase

import com.google.inject.Inject
import domain.lifecycle.DeleteLiftTypesFromTrainingMenuRepositoryInterface

import scala.concurrent.Future

case class DeleteLiftTypesFromTrainingMenuService @Inject()(repository: DeleteLiftTypesFromTrainingMenuRepositoryInterface) {
  def apply(trainingMenuId: Int, req: List[Int]): Future[Boolean] = repository.execute(trainingMenuId, req)
}
