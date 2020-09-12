package infrastructure

import domain.{LiftAction, RegisterLiftTypesToTrainingMenuRepositoryInterface, Target}
import dto.RegisterLiftTypesToTrainingMenuRequest
import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class RegisterLiftTypesToTrainingMenuRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, models: Models)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] with RegisterLiftTypesToTrainingMenuRepositoryInterface {

  import profile.api._

  private val LiftActions = TableQuery[models.LiftActionsTable]
  private val Targets = TableQuery[models.TargetsTable]

  def execute(req: RegisterLiftTypesToTrainingMenuRequest): List[Future[Int]] = {
    req.liftTypes.map { liftType =>
      db.run((for {
        liftActionId <- (LiftActions returning LiftActions.map(_.id.getOrElse(0))) += LiftAction(
          id = Some(0),
          liftTypeId = liftType.id,
          trainingMenuId = req.trainingMenuId,
          lightRep = liftType.lightRep,
          lightWeight = liftType.lightWeight,
          lightSetCount = liftType.lightSetCount,
          heavyRep = liftType.heavyRep,
          heavyWeight = liftType.heavyWeight,
          heavySetCount = liftType.heavySetCount
        )
        result <- Targets += Target(
          id = Some(0),
          liftActionId = liftActionId,
          bodyPartId = liftType.targetBodyPartId,
          isMain = liftType.isMain
        )
      } yield result).transactionally)
    }
  }
}