package infrastructure

import com.google.inject.Inject
import domain._
import domain.lifecycle.LiftTypeRepositoryInterface
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class LiftTypeRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, models: Models)
    (implicit executionContext: ExecutionContext)
    extends HasDatabaseConfigProvider[JdbcProfile] with LiftTypeRepositoryInterface {

  import profile.api._

  private val LiftTypes = TableQuery[models.LiftTypesTable]

  def index(): Future[List[LiftType]] = db.run(LiftTypes.result).map(_.toList)

  def findById(id: Int): Future[Option[LiftType]] = db.run(LiftTypes.filter(_.id === id).result.headOption)

  def findByUserId(userId: Int): Future[List[LiftType]] = db.run(LiftTypes.filter(_.userId === userId).result).map(_.toList)

  def insert(liftType: LiftType):  Future[Option[LiftType]] = Option(db.run(LiftTypes returning LiftTypes += liftType)) match {
    case Some(liftType) => liftType.map{Some(_)}
    case None => Future.successful(None)
  }

  def update(liftType: LiftType): Future[Option[LiftType]] = db.run(LiftTypes.filter(_.id === liftType.id).update(liftType)).map {
    case 0 => None
    case _ => Some(liftType)
  }

  def updateDefaultAction(
      liftTypeId: Int,
      defaultRep: Int,
      defaultSetCount: Int,
      defaultWeight: Int): Future[Option[(Int, Int, Int, Int)]] =
    db.run(
      LiftTypes
          .filter(_.id === liftTypeId)
          .map(liftType => (liftType.defaultWeight, liftType.defaultRep, liftType.defaultSetCount))
          .update((defaultWeight, defaultRep, defaultSetCount))
    ).map {
      case 0 => None
      case _ => Some(
        liftTypeId,
        defaultRep,
        defaultSetCount,
        defaultWeight)
    }

  def share(liftTypeId: Int): Future[Int] = db.run(LiftTypes.filter(_.id === liftTypeId).map(_.shareFlag).update(true))

  def delete(id: Int): Future[Boolean] = db.run(LiftTypes.filter(_.id === id).delete).map {
    case 0 => false
    case _ => true
  }


}