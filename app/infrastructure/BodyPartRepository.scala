package infrastructure

import domain._
import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class BodyPartRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  private val BodyParts = TableQuery[BodyPartsTable]

  def index(): Future[Seq[BodyPart]] = db.run(BodyParts.result)

  def findById(id: Int): Future[BodyPart] = db.run(BodyParts.filter(_.id === id).result.head)

  def insert(liftType: BodyPart): Future[Int] = db.run(BodyParts += liftType)

  def update(liftType: BodyPart): Future[Int] = db.run(BodyParts.filter(_.id === liftType.id).update(liftType))

  def delete(id: Int): Future[Int] = db.run(BodyParts.filter(_.id === id).delete)

  private class BodyPartsTable(tag: Tag) extends Table[BodyPart](tag, "body_parts") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)

    def name = column[String]("name")

    def * = (id, name) <> (BodyPart.tupled, BodyPart.unapply)

  }

}