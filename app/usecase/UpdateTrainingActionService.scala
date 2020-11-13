package usecase

import com.google.inject.{Inject, Singleton}
import domain.{LiftAction, LiftActionRepositoryInterface, LiftTypeRepositoryInterface}
import dto.MenuLiftActionRequest

import scala.concurrent.{ExecutionContext, Future}

@Singleton
case class UpdateTrainingActionService @Inject()
(
    liftActionRepository: LiftActionRepositoryInterface,
    liftTypeRepository: LiftTypeRepositoryInterface,
)(implicit executionContext: ExecutionContext) {

  def apply(actions: List[MenuLiftActionRequest]): Future[Int] =
    actions
        .map { action =>
          updateDefaultAction(action)
          liftActionRepository
              .findByForeignKeyId(liftTypeId = action.id, menuId = action.trainingMenuId)
              .map(_.id)
              .flatMap { actionId => updateLiftAction(actionId, action) }
        }
        .reduce { (acc, cur) => acc.flatMap { acc_v => cur.map(cur_v => acc_v * cur_v) } }

  def updateDefaultAction(action: MenuLiftActionRequest): Future[Int] =
    liftTypeRepository.updateDefaultAction(
      liftTypeId = action.id,
      defaultWeight = action.defaultWeight,
      defaultRep = action.defaultRep,
      defaultSetCount = action.defaultSetCount
    )

  def updateLiftAction(actionId: Option[Int], action: MenuLiftActionRequest): Future[Int] =
    liftActionRepository.update(
      LiftAction(
        id = actionId,
        liftTypeId = action.id,
        trainingMenuId = action.trainingMenuId,
        lightRep = action.lightRep,
        lightWeight = action.lightWeight,
        lightSetCount = action.lightSetCount,
        heavyRep = action.heavyRep,
        heavyWeight = action.heavyWeight,
        heavySetCount = action.heavySetCount
      )
    )
}