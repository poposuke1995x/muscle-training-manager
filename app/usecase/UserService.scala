package usecase

import com.google.inject.Inject
import domain.{User, UserRepositoryInterface}

import scala.concurrent.{ExecutionContext, Future}

case class UserService @Inject()(repository: UserRepositoryInterface)(implicit executionContext: ExecutionContext) {

  def createGuestUser(uid: String): Future[Int] = repository.insert(User(None, "guest", uid))

  def getUserId(firebaseUid: String): Future[Int] = repository.findIdByUid(firebaseUid)

}
