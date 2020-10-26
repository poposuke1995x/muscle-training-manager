package infrastructure

import domain.{LiftAction, RegisterLiftTypesToTrainingMenuRepositoryInterface, Target}
import dto.TargetedLiftTypeRequest
import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class RegisterLiftTypesToTrainingMenuRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, models: Models)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] with RegisterLiftTypesToTrainingMenuRepositoryInterface {

  import profile.api._

  private val LiftActions = TableQuery[models.LiftActionsTable]
  private val Targets = TableQuery[models.TargetsTable]

  def execute(trainingMenuId: Int, req: List[TargetedLiftTypeRequest]): List[Future[Int]] = {
    req.map { liftType =>
      db.run((for {
        liftActionId <- (LiftActions returning LiftActions.map(_.id.getOrElse(0))) += LiftAction(
          id = Some(0),
          liftTypeId = liftType.id,
          trainingMenuId = trainingMenuId,
          lightRep = liftType.lightRep,
          lightWeight = liftType.lightWeight,
          lightSetCount = liftType.lightSetCount,
          heavyRep = liftType.heavyRep,
          heavyWeight = liftType.heavyWeight,
          heavySetCount = liftType.heavySetCount
        )
        _ <- DBIO.seq(liftType.targetBodyPartIds.map(bodyPartId => Targets += Target(
          id = Some(0),
          liftActionId = liftActionId,
          bodyPartId = bodyPartId,
          isMain = liftType.isMain== bodyPartId
        )): _*)
      } yield 1).transactionally)
    }
  }
}