package infrastructure

import com.google.inject.Inject
import domain.{LiftAction, UpdateTrainingActionRepositoryInterface}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class UpdateTrainingActionRepository @Inject()
(protected val dbConfigProvider: DatabaseConfigProvider, models: Models)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] with UpdateTrainingActionRepositoryInterface {

  import profile.api._

  private val LiftActions = TableQuery[models.LiftActionsTable]

  override def execute(actions: List[LiftAction]): Future[Int] = Option(
    db.run({
      DBIO.seq(actions.map(action =>
        LiftActions
          .filter(_.liftTypeId === action.liftTypeId)
          .filter(_.trainingMenuId === action.trainingMenuId)
          .update(action)
      ): _*).transactionally
    })
  ) match {
    case Some(_) => Future(1)
    case None => Future(0)
  }
}
