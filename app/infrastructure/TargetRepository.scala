package infrastructure

import domain._
import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class TargetRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  private val Targets = TableQuery[TargetsTable]

  def all(): Future[Seq[Target]] = db.run(Targets.result)

  def findById(id: Int): Future[Target] = db.run(Targets.filter(_.id === id).result.head)

  def insert(target: Target): Future[Int] = db.run(Targets += target)

  def updateIsMain(id: Int, isMain: Boolean): Future[Int] = db.run(
    Targets
      .filter(_.id === id)
      .map {
        _.isMain
      }
      .update(isMain)
  )

  def delete(id: Int): Future[Int] = db.run(Targets.filter(_.id === id).delete)

  private class TargetsTable(tag: Tag) extends Table[Target](tag, "targets") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)

    def liftActionId = column[Int]("lift_action_id")

    def bodyPartId = column[Int]("body_part_id")

    def isMain = column[Boolean]("is_main")

    def * = (id, liftActionId, bodyPartId, isMain) <> (Target.tupled, Target.unapply)

  }

}