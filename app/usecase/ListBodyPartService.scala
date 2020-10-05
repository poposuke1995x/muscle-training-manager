package usecase

import com.google.inject.Inject
import domain.{BodyPart, BodyPartRepositoryInterface}

import scala.concurrent.Future

case class ListBodyPartService @Inject()(repository: BodyPartRepositoryInterface) {
  def apply(): Future[List[BodyPart]] = repository.index()
}
