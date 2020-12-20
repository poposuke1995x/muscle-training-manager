package usecase

import com.google.inject.Inject
import domain.lifecycle.RegisterLiftTypesToTrainingMenuRepositoryInterface
import usecase.dto.TargetedLiftTypeRequest

import scala.concurrent.Future

case class RegisterLiftTypesToTrainingMenuService @Inject()(repository: RegisterLiftTypesToTrainingMenuRepositoryInterface) {
  def apply(trainingMenuId: Int, req: List[TargetedLiftTypeRequest]): Future[List[Int]] =
    repository.execute(trainingMenuId: Int, req)
}
