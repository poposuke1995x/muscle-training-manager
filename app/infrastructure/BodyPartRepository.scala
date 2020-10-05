package infrastructure

import domain._
import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import scala.concurrent.{ExecutionContext, Future}

class BodyPartRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, models: Models)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] with BodyPartRepositoryInterface {

  import profile.api._


  private val BodyParts = TableQuery[models.BodyPartsTable]

  def index(): Future[List[BodyPart]] = db.run(BodyParts.result).map(_.toList)

  def findById(id: Int): Future[BodyPart] = db.run(BodyParts.filter(_.id === id).result.head)

  def insert(bodyPart: BodyPart): Future[Int] = db.run(BodyParts returning BodyParts.map(_.id.getOrElse(0)) += bodyPart)

  def update(bodyPart: BodyPart): Future[Int] = db.run(BodyParts.filter(_.id === bodyPart.id).update(bodyPart))

  def delete(id: Int): Future[Int] = db.run(BodyParts.filter(_.id === id).delete)


}