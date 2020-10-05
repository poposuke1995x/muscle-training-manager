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

  override def execute(actions: List[LiftAction]): Future[Int] = try {
    db.run({
      DBIO.seq(actions.map(action =>
        LiftActions.filter(_.id === action.id).update(action)
      ): _*)
    })
    Future(1)
  }
  catch {
    case e: Any =>
      Future(0)
  }
}
