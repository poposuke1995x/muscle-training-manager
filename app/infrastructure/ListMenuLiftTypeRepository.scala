package infrastructure

import com.google.inject.Inject
import domain.{LiftType, ListMenuLiftTypeRepositoryInterface}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import scala.concurrent.{ExecutionContext, Future}

class ListMenuLiftTypeRepository @Inject()
(protected val dbConfigProvider: DatabaseConfigProvider, models: Models)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] with ListMenuLiftTypeRepositoryInterface {

  import profile.api._

  private val LiftActions = TableQuery[models.LiftActionsTable]
  private val LiftTypes = TableQuery[models.LiftTypesTable]

  def execute(trainingMenuId: Int, bodyPartId: Option[Int]): Future[Seq[LiftType]] = db.run(
    (for {
      liftTypeIds <- LiftActions
        .filter(_.trainingMenuId === trainingMenuId)
        .map(_.liftTypeId)
        .result
      result <- LiftTypes
        .filter(_.id inSetBind liftTypeIds)
        .result
    } yield result).transactionally
  )
}
