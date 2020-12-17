package infrastructure.datasource

import domain.{User, UserRepositoryInterface}
import infrastructure.Models
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class UserRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, models: Models)
    (implicit executionContext: ExecutionContext)
    extends HasDatabaseConfigProvider[JdbcProfile] with UserRepositoryInterface {

  import profile.api._

  private val Users = TableQuery[models.UsersTable]

//  def index(): Future[Seq[User]] = db.run(Users.result)

//  def findById(id: Int): Future[User] = db.run(Users.filter(_.id === id).result.head)

  def findIdByUid(uid: String): Future[Int] = db.run(Users.filter(_.firebase_uid === uid).result.headOption.map {
    case Some(user) => user.id.get
    case None => 0
  })

  def insert(user: User): Future[Int] = db.run((Users returning Users.map(_.id.getOrElse(0))) += user)

  def update(user: User): Future[Int] = db.run(Users.filter(_.id === user.id).update(user))

  def delete(id: Int): Future[Int] = db.run(Users.filter(_.id === id).delete)


}