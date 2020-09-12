package infrastructure

import domain._
import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class LiftTypeRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, models: Models)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] with LiftTypeRepositoryInterface {

  import profile.api._

  private val LiftTypes = TableQuery[models.LiftTypesTable]

  def index(): Future[Seq[LiftType]] = db.run(LiftTypes.result)

  def findById(id: Int): Future[LiftType] = db.run(LiftTypes.filter(_.id === id).result.head)

  def insert(liftType: LiftType): Future[Int] = db.run(LiftTypes += liftType)

  def update(liftType: LiftType): Future[Int] = db.run(LiftTypes.filter(_.id === liftType.id).update(liftType))

  def delete(id: Int): Future[Int] = db.run(LiftTypes.filter(_.id === id).delete)


}