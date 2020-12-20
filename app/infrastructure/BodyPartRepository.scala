package infrastructure

import com.google.inject.Inject
import domain._
import domain.lifecycle.BodyPartRepositoryInterface
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class BodyPartRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, models: Models)
    (implicit executionContext: ExecutionContext)
    extends HasDatabaseConfigProvider[JdbcProfile] with BodyPartRepositoryInterface {

  import profile.api._


  private val BodyParts = TableQuery[models.BodyPartsTable]

  def index(): Future[List[BodyPart]] = db.run(BodyParts.result).map(_.toList)

  def findById(id: Int): Future[Option[BodyPart]] = db.run(BodyParts.filter(_.id === id).result.headOption)

  def insert(bodyPart: BodyPart): Future[Option[BodyPart]] =
    Option(db.run(BodyParts returning BodyParts += bodyPart)) match {
      case Some(value) => value.map(Some(_))
      case None => Future.successful(None)
    }

  def update(bodyPart: BodyPart): Future[Option[BodyPart]] =
    db.run(BodyParts.filter(_.id === bodyPart.id).update(bodyPart)).map {
      case 0 => None
      case _ => Some(bodyPart)
    }

  def delete(id: Int): Future[Boolean] = db.run(BodyParts.filter(_.id === id).delete).map {
    case 0 => false
    case _ => true
  }


}