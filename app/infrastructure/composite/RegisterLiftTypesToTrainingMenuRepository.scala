package infrastructure.composite

import domain.lifecycle.RegisterLiftTypesToTrainingMenuRepositoryInterface
import domain.{LiftAction, Target}
import infrastructure.Models
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import usecase.dto.TargetedLiftTypeRequest

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class RegisterLiftTypesToTrainingMenuRepository @Inject()(
    protected val dbConfigProvider: DatabaseConfigProvider,
    models: Models)(implicit executionContext: ExecutionContext)
    extends HasDatabaseConfigProvider[JdbcProfile] with RegisterLiftTypesToTrainingMenuRepositoryInterface {

  import profile.api._

  private val LiftActions = TableQuery[models.LiftActionsTable]
  private val Targets = TableQuery[models.TargetsTable]

  def execute(trainingMenuId: Int, req: List[TargetedLiftTypeRequest]): Future[List[Int]] =
    Future.sequence {
      req.map { liftType =>
        db.run((for {
          liftActionId <- (LiftActions returning LiftActions.map(_.id.getOrElse(0))) +=
              LiftAction(
                id = None,
                liftTypeId = liftType.id,
                trainingMenuId = trainingMenuId,
                lightRep = liftType.lightRep,
                lightWeight = liftType.lightWeight,
                lightSetCount = liftType.lightSetCount,
                heavyRep = liftType.heavyRep,
                heavyWeight = liftType.heavyWeight,
                heavySetCount = liftType.heavySetCount
              )

          _ <- Targets ++= liftType.targetBodyPartIds.map { bodyPartId =>
            Target(
              id = None,
              liftActionId = liftActionId,
              bodyPartId = bodyPartId,
              isMain = liftType.isMain == bodyPartId
            )
          }
        } yield liftType.id).transactionally)
      }
    }
}