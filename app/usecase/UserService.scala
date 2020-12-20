package usecase

import com.google.inject.Inject
import domain.User
import domain.lifecycle.UserRepositoryInterface

import scala.concurrent.{ExecutionContext, Future}

case class UserService @Inject()(repository: UserRepositoryInterface)(implicit executionContext: ExecutionContext) {

  def createGuestUser(uid: String): Future[Option[User]] = repository.insert(User(None, "guest", uid))

  def getUserId(firebaseUid: String): Future[Option[Int]] = repository.findIdByUid(firebaseUid)

}
