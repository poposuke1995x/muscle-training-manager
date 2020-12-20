package infrastructure

import com.google.inject.Inject

import scala.concurrent.{ExecutionContext, Future}
import domain.User
import domain.lifecycle.UserRepositoryInterface
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

class UserRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, models: Models)
    (implicit executionContext: ExecutionContext)
    extends HasDatabaseConfigProvider[JdbcProfile] with UserRepositoryInterface {

  import profile.api._

  private val Users = TableQuery[models.UsersTable]

  def findIdByUid(uid: String): Future[Option[Int]] = db.run(Users.filter(_.firebase_uid === uid).map(_.id).result.headOption).map {
    value => value.flatten
  }

  def insert(user: User): Future[Option[User]] =Option( db.run((Users returning Users) += user))match {
    case Some(user) => user.map(Some(_))
    case None => Future.successful(None)
  }

//  def update(user: User): Future[Option[User]] = db.run(Users.filter(_.id === user.id).update(user))

//  def delete(id: Int): Future[Int] = db.run(Users.filter(_.id === id).delete)


}