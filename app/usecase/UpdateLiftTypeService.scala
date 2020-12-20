package usecase

import com.google.inject.{Inject, Singleton}
import domain.LiftType
import domain.lifecycle.LiftTypeRepositoryInterface
import usecase.dto.LiftTypeRequest

import scala.concurrent.{ExecutionContext, Future}

case class UpdateLiftTypeService @Inject()
(repository: LiftTypeRepositoryInterface)(implicit executionContext: ExecutionContext) {
  def apply(liftTypeId: Int, liftTypeRequest: LiftTypeRequest): Future[Option[LiftType]] = {
    repository.findById(liftTypeId).flatMap {
      case None => Future.successful(None)
      case Some(liftType) => repository.update(
        genLiftType(liftTypeId, liftType, liftTypeRequest)
      )
    }
  }

  def genLiftType(liftTypeId: Int, origin: LiftType, liftTypeRequest: LiftTypeRequest): LiftType = LiftType(
    id = Some(liftTypeId),
    name = liftTypeRequest.name.getOrElse(origin.name),
    referenceUrl = liftTypeRequest.referenceUrl.getOrElse(origin.referenceUrl),
    description = liftTypeRequest.description.getOrElse(origin.description),
    userId = origin.userId,
    defaultRep = liftTypeRequest.defaultRep.getOrElse(origin.defaultRep),
    defaultWeight = liftTypeRequest.defaultWeight.getOrElse(origin.defaultWeight),
    defaultSetCount = liftTypeRequest.defaultSetCount.getOrElse(origin.defaultSetCount),
    shareFlag = origin.shareFlag
  )

}
