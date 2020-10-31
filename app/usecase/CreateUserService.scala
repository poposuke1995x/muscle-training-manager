package usecase

import com.google.inject.Inject
import domain.{User, UserRepositoryInterface}

import scala.concurrent.Future

case class CreateUserService @Inject()(repository: UserRepositoryInterface) {
  def apply(user: User): Future[Int] = {
    repository
      .insert(user)
  }

}
