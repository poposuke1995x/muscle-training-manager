package usecase

import com.google.inject.{Inject, Singleton}
import domain.{LiftType, LiftTypeRepositoryInterface}
import usecase.dto.LiftTypeRequest

import scala.concurrent.{ExecutionContext, Future}

@Singleton
case class UpdateLiftTypeService @Inject()
(repository: LiftTypeRepositoryInterface)(implicit executionContext: ExecutionContext) {
  def apply(liftTypeId: Int, liftTypeRequest: LiftTypeRequest): Future[Int] = {
    for {
      origin: LiftType <- repository.findById(liftTypeId)
      result <- repository.update(
        genLiftType(liftTypeId, origin, liftTypeRequest)
      )
    } yield result
  }

  def genLiftType(liftTypeId: Int, origin: LiftType, liftTypeRequest: LiftTypeRequest): LiftType = LiftType(
    id = Some(liftTypeId),
    name = liftTypeRequest.name.getOrElse(origin.name),
    referenceUrl = liftTypeRequest.referenceUrl.getOrElse(origin.referenceUrl),
    description = liftTypeRequest.description.getOrElse(origin.description),
    importedCount = origin.importedCount,
    userId = origin.userId,
    defaultRep = liftTypeRequest.defaultRep.getOrElse(origin.defaultRep),
    defaultWeight = liftTypeRequest.defaultWeight.getOrElse(origin.defaultWeight),
    defaultSetCount = liftTypeRequest.defaultSetCount.getOrElse(origin.defaultSetCount),
    shareFlag = origin.shareFlag
  )
  
}
