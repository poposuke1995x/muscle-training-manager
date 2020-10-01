package usecase

import com.google.inject.Inject
import domain.RegisterLiftTypesToTrainingMenuRepositoryInterface
import dto.RegisterLiftTypesToTrainingMenuRequest
import scala.concurrent.Future

case class RegisterLiftTypesToTrainingMenuService @Inject()(repository: RegisterLiftTypesToTrainingMenuRepositoryInterface) {
  def apply(trainingMenuId: Int, req: RegisterLiftTypesToTrainingMenuRequest): List[Future[Int]] = repository.execute(trainingMenuId: Int, req)
}
