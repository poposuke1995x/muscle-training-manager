package infrastructure

import domain.DeleteLiftTypesFromTrainingMenuRepositoryInterface
import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class DeleteLiftTypesFromTrainingMenuRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, models: Models)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] with DeleteLiftTypesFromTrainingMenuRepositoryInterface {

  import profile.api._

  private val LiftActions = TableQuery[models.LiftActionsTable]

  def execute(trainingMenuId: Int, liftTypeIds: List[Int]): Future[Int] = {
    db.run(
      LiftActions
        .filter(_.trainingMenuId === trainingMenuId)
        .filter(_.liftTypeId inSetBind liftTypeIds)
        .delete
    )
  }
}