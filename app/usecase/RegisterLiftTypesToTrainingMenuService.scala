package usecase

import com.google.inject.Inject
import domain.RegisterLiftTypesToTrainingMenuRepositoryInterface
import usecase.dto.TargetedLiftTypeRequest

import scala.concurrent.Future

case class RegisterLiftTypesToTrainingMenuService @Inject()(repository: RegisterLiftTypesToTrainingMenuRepositoryInterface) {
  def apply(trainingMenuId: Int, req: List[TargetedLiftTypeRequest]): List[Future[Int]] =
    repository.execute(trainingMenuId: Int, req)
}
