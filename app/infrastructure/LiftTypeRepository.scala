package infrastructure

import domain._
import domain.repositories.LiftTypeRepositoryInterface
import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class LiftTypeRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] with LiftTypeRepositoryInterface{

  import profile.api._

  private val LiftTypes = TableQuery[LiftTypesTable]

  def index(): Future[Seq[LiftType]] = db.run(LiftTypes.result)

  def findById(id: Int): Future[LiftType] = db.run(LiftTypes.filter(_.id === id).result.head)

  def insert(liftType: LiftType): Future[Int] = db.run(LiftTypes += liftType)

  def update(liftType: LiftType): Future[Int] = db.run(LiftTypes.filter(_.id === liftType.id).update(liftType))

  def delete(id: Int): Future[Int] = db.run(LiftTypes.filter(_.id === id).delete)

  private class LiftTypesTable(tag: Tag) extends Table[LiftType](tag, "lift_types") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)

    def name = column[String]("name")

    def referenceUrl = column[Option[String]]("reference_url")

    def description = column[Option[String]]("description")

    def importedCount = column[Int]("imported_count")

    def serverUid = column[String]("server_uid")

    def defaultRep = column[Int]("default_rep")

    def defaultWeight = column[Int]("default_weight")

    def defaultSetCount = column[Int]("default_set_count")

    def shareFlag = column[Boolean]("share_flag")

    def * = (
      id,
      name,
      referenceUrl,
      description,
      importedCount,
      serverUid,
      defaultRep,
      defaultWeight,
      defaultSetCount,
      shareFlag
    ) <> (LiftType.tupled, LiftType.unapply)

  }

}