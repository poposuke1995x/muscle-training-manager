package infrastructure.datasource

import domain.{TargetRepositoryInterface, _}
import infrastructure.Models
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class TargetRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, models: Models)
    (implicit executionContext: ExecutionContext)
    extends HasDatabaseConfigProvider[JdbcProfile] with TargetRepositoryInterface {

  import profile.api._

  private val Targets = TableQuery[models.TargetsTable]

  def index(): Future[Seq[Target]] = db.run(Targets.result)

  def findById(id: Int): Future[Target] = db.run(Targets.filter(_.id === id).result.head)

  def insert(target: Target): Future[Int] = db.run(Targets += target)

  def updateIsMain(id: Int, isMain: Boolean): Future[Int] = db.run(
    Targets
        .filter(_.id === id)
        .map(_.isMain)
        .update(isMain)
  )

  def delete(id: Int): Future[Int] = db.run(Targets.filter(_.id === id).delete)


}