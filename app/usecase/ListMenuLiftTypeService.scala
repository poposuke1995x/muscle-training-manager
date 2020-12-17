package usecase

import com.google.inject.Inject
import domain.{LiftAction, LiftType, ListMenuLiftTypeRepositoryInterface}
import usecase.dto.LiftTypesInTrainingMenuResponse

import scala.concurrent.{ExecutionContext, Future}

case class ListMenuLiftTypeService @Inject()(repository: ListMenuLiftTypeRepositoryInterface)
    (implicit executionContext: ExecutionContext) {
  def apply(trainingMenuId: Int, bodyPartId: Option[Int]): Future[List[LiftTypesInTrainingMenuResponse]] =
    repository
        .execute(trainingMenuId: Int, bodyPartId: Option[Int])
        .map { resp =>
          val types = resp._1.toList
          val actions = resp._2.toList
          types.map { liftType =>
            val action = actions.filter(action => liftType.id.getOrElse(0) == action.liftTypeId).head
            genResponse(liftType, action)
          }
        }

  def genResponse(
      liftType: LiftType,
      action: LiftAction): LiftTypesInTrainingMenuResponse =
    LiftTypesInTrainingMenuResponse(
      id = liftType.id,
      name = liftType.name,
      description = liftType.description,
      userId = liftType.userId,
      defaultRep = liftType.defaultRep,
      defaultWeight = liftType.defaultWeight,
      defaultSetCount = liftType.defaultSetCount,
      lightRep = action.lightRep,
      lightWeight = action.lightWeight,
      lightSetCount = action.lightSetCount,
      heavyRep = action.heavyRep,
      heavyWeight = action.heavyWeight,
      heavySetCount = action.heavySetCount,
      referenceUrl = liftType.referenceUrl
    )
}
