package infrastructure.datasource

import domain.{LiftActionRepositoryInterface, _}
import infrastructure.Models
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class LiftActionRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, models: Models)
    (implicit executionContext: ExecutionContext)
    extends HasDatabaseConfigProvider[JdbcProfile] with LiftActionRepositoryInterface {

  import profile.api._

  private val LiftActions = TableQuery[models.LiftActionsTable]

  def index(): Future[Seq[LiftAction]] = db.run(LiftActions.result)

  def findById(id: Int): Future[LiftAction] = db.run(LiftActions.filter(_.id === id).result.head)

  def findByForeignKeyId(liftTypeId: Int, menuId: Int): Future[LiftAction] = db.run(
    LiftActions
        .filter(_.liftTypeId === liftTypeId)
        .filter(_.trainingMenuId === menuId)
        .result.head
  )

  def insert(liftAction: LiftAction): Future[Int] = db.run(LiftActions += liftAction)

  def update(liftAction: LiftAction): Future[Int] = db.run(LiftActions.filter(_.id === liftAction.id).update(liftAction))

  def delete(id: Int): Future[Int] = db.run(LiftActions.filter(_.id === id).delete)


}