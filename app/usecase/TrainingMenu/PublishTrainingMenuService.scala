package usecase.TrainingMenu

import com.google.inject.Inject
import domain.{TrainingMenu, TrainingMenuRepositoryInterface}
import scala.concurrent.{ExecutionContext, Future}

case class PublishTrainingMenuService @Inject()(repository: TrainingMenuRepositoryInterface)(implicit executionContext: ExecutionContext) {
  def apply(id: Int): Future[Int] = for {
    trainingMenu <- repository.findById(id)
    result <- repository.update(updateObj(trainingMenu))
  } yield result

  def updateObj(obj: TrainingMenu): TrainingMenu = {
    TrainingMenu(
      id = obj.id,
      name = obj.name,
      categoryId = obj.categoryId,
      description = obj.description,
      importedCount = obj.importedCount,
      userUid = obj.userUid,
      shareFlag = true
    )
  }
}
