package usecase

import com.google.inject.Inject
import domain.LiftAction
import domain.lifecycle.{LiftActionRepositoryInterface, LiftTypeRepositoryInterface}
import usecase.dto.MenuLiftActionRequest

import scala.concurrent.{ExecutionContext, Future}

case class UpdateTrainingActionService @Inject()
(
    liftActionRepository: LiftActionRepositoryInterface,
    liftTypeRepository: LiftTypeRepositoryInterface,
)(implicit executionContext: ExecutionContext) {

  def apply(actions: List[MenuLiftActionRequest]): Future[Option[List[LiftAction]]] = Future.sequence {
    actions
        .map { action =>
          updateDefaultAction(action)
          liftActionRepository
              .findByForeignKeyId(liftTypeId = action.id, menuId = action.trainingMenuId)
              .flatMap {
                case Some(foundAction) => updateLiftAction(foundAction.id, action)
                case None => Future.successful(None)
              }
        }
  }.map { v => Option(v.flatten) }

  def updateDefaultAction(action: MenuLiftActionRequest): Future[Option[(Int, Int, Int, Int)]] =
    liftTypeRepository.updateDefaultAction(
      liftTypeId = action.id,
      defaultWeight = action.defaultWeight,
      defaultRep = action.defaultRep,
      defaultSetCount = action.defaultSetCount
    )

  def updateLiftAction(actionId: Option[Int], action: MenuLiftActionRequest): Future[Option[LiftAction]] =
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