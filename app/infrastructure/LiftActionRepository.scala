package infrastructure

import domain._
import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class LiftActionRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  private val LiftActions = TableQuery[LiftActionsTable]

  def all(): Future[Seq[LiftAction]] = db.run(LiftActions.result)

  def findById(id: Int): Future[LiftAction] = db.run(LiftActions.filter(_.id === id).result.head)

  def insert(liftAction: LiftAction): Future[Int] = db.run(LiftActions += liftAction)

  def update(liftAction: LiftAction): Future[Int] = db.run(LiftActions.filter(_.id === liftAction.id).update(liftAction))

  def delete(id: Int): Future[Int] = db.run(LiftActions.filter(_.id === id).delete)

  private class LiftActionsTable(tag: Tag) extends Table[LiftAction](tag, "lift_actions") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)

    def liftTypeId = column[Int]("lift_type_id")

    def trainingMenuId = column[Int]("training_menu_id")

    def lightRep = column[Int]("light_rep")

    def lightWeight = column[Int]("light_weight")

    def lightSetCount = column[Int]("light_set_count")

    def heavyRep = column[Int]("heavy_rep")

    def heavyWeight = column[Int]("heavy_weight")

    def heavySetCount = column[Int]("heavy_set_count")

    def * = (
      id,
      liftTypeId,
      trainingMenuId,
      lightRep,
      lightWeight,
      lightSetCount,
      heavyRep,
      heavyWeight,
      heavySetCount,
    ) <> (LiftAction.tupled, LiftAction.unapply)

  }

}