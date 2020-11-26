package infrastructure

import com.google.inject.Inject
import domain._
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class LiftTypeRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, models: Models)
    (implicit executionContext: ExecutionContext)
    extends HasDatabaseConfigProvider[JdbcProfile] with LiftTypeRepositoryInterface {

  import profile.api._

  private val LiftTypes = TableQuery[models.LiftTypesTable]

  def index(): Future[Seq[LiftType]] = db.run(LiftTypes.result)

  def findById(id: Int): Future[LiftType] = db.run(LiftTypes.filter(_.id === id).result.head)

  def findByUserId(userId: Int): Future[Seq[LiftType]] = db.run(LiftTypes.filter(_.userId === userId).result)

  def insert(liftType: LiftType): Future[Int] = db.run(LiftTypes += liftType)

  def update(liftType: LiftType): Future[Int] = db.run(LiftTypes.filter(_.id === liftType.id).update(liftType))

  def updateDefaultAction(
      liftTypeId: Int,
      defaultRep: Int,
      defaultSetCount: Int,
      defaultWeight: Int): Future[Int] =
    db.run(
      LiftTypes
          .filter(_.id === liftTypeId)
          .map(liftType => (liftType.defaultWeight, liftType.defaultRep, liftType.defaultSetCount))
          .update((defaultWeight, defaultRep, defaultSetCount))
    )

  def share(liftTypeId: Int): Future[Int] = db.run(LiftTypes.filter(_.id === liftTypeId).map(_.shareFlag).update(true))

  def delete(id: Int): Future[Int] = db.run(LiftTypes.filter(_.id === id).delete)


}