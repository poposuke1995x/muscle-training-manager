package infrastructure

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import domain.{User, UserRepositoryInterface}
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

class UserRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, models: Models)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] with UserRepositoryInterface {

  import profile.api._

  private val Users = TableQuery[models.UsersTable]

  def index(): Future[Seq[User]] = db.run(Users.result)

  def findById(id: Int): Future[User] = db.run(Users.filter(_.id === id).result.head)

  def findIdByUid(uid: String): Future[Int] = db.run(Users.filter(_.firebase_uid === uid).result.head.map(_.id.getOrElse(0)))

  def insert(user: User): Future[Int] = db.run(Users += user)

  def update(user: User): Future[Int] = db.run(Users.filter(_.id === user.id).update(user))

  def delete(id: Int): Future[Int] = db.run(Users.filter(_.id === id).delete)


}