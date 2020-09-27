package usecase

import com.google.inject.Inject
import domain.{LiftType, LiftTypeRepositoryInterface}

import scala.concurrent.{ExecutionContext, Future}

case class ShareLiftTypeService @Inject()(repository: LiftTypeRepositoryInterface)(implicit executionContext: ExecutionContext) {
  def apply(id: Int): Future[Int] = for {
    liftType <- repository.findById(id)
    result <- repository.update(updateObj(liftType))
  } yield result

  def updateObj(obj: LiftType): LiftType = {
    LiftType(
      id = obj.id,
      name = obj.name,
      referenceUrl = obj.referenceUrl,
      description = obj.description,
      importedCount = obj.importedCount,
      userId = obj.userId,
      defaultRep = obj.defaultRep,
      defaultWeight = obj.defaultWeight,
      defaultSetCount = obj.defaultSetCount,
      shareFlag = true
    )
  }
}
