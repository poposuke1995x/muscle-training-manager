package usecase

import com.google.inject.{Inject, Singleton}
import domain.LiftType
import domain.lifecycle.LiftTypeRepositoryInterface

import scala.concurrent.Future

case class ListUserLiftTypeService @Inject()(repository: LiftTypeRepositoryInterface) {
  def apply(userId: Int): Future[List[LiftType]] = repository.findByUserId(userId)
}
