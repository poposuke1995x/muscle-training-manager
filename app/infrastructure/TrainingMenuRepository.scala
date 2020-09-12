package infrastructure

import domain._
import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class TrainingMenuRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, models: Models)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] with TrainingMenuRepositoryInterface {

  import profile.api._

  private val TrainingMenuObj = TableQuery[models.TrainingMenuTable]

  def index(): Future[Seq[TrainingMenu]] = db.run(TrainingMenuObj.result)

  def findById(id: Int): Future[TrainingMenu] = db.run(TrainingMenuObj.filter(_.id === id).result.head)

  def insert(trainingMenu: TrainingMenu): Future[Int] = db.run((TrainingMenuObj returning TrainingMenuObj.map(_.id.get)) += trainingMenu)

  def update(trainingMenu: TrainingMenu): Future[Int] = db.run(TrainingMenuObj.filter(_.id === trainingMenu.id).update(trainingMenu))

  def delete(id: Int): Future[Int] = db.run(TrainingMenuObj.filter(_.id === id).delete)


}