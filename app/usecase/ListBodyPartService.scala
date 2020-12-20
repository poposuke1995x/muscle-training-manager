package usecase

import com.google.inject.Inject
import domain.BodyPart
import domain.lifecycle.BodyPartRepositoryInterface

import scala.concurrent.Future

case class ListBodyPartService @Inject()(repository: BodyPartRepositoryInterface) {
  def apply(): Future[List[BodyPart]] = repository.index()
}
