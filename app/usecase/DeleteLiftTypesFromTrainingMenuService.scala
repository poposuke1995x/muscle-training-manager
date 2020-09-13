package usecase

import com.google.inject.Inject
import domain.DeleteLiftTypesFromTrainingMenuRepositoryInterface

import scala.concurrent.Future

case class DeleteLiftTypesFromTrainingMenuService @Inject()(repository: DeleteLiftTypesFromTrainingMenuRepositoryInterface) {
  def apply(trainingMenuId: Int, req: List[Int]): Future[Int] = repository.execute(trainingMenuId, req)
}
