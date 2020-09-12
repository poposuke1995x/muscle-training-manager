package usecase

import com.google.inject.Inject
import domain.RegisterLiftTypesToTrainingMenuRepositoryInterface
import dto.RegisterLiftTypesToTrainingMenuRequest

import scala.concurrent.Future

case class RegisterLiftTypesToTrainingMenuService @Inject()(repository: RegisterLiftTypesToTrainingMenuRepositoryInterface) {
  def apply(req: RegisterLiftTypesToTrainingMenuRequest): List[Future[Int]] = repository.execute(req)
}
