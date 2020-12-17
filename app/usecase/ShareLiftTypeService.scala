package usecase

import com.google.inject.Inject
import domain.LiftTypeRepositoryInterface

import scala.concurrent.{ExecutionContext, Future}

case class ShareLiftTypeService @Inject()(repository: LiftTypeRepositoryInterface)(implicit executionContext: ExecutionContext) {
  def apply(id: Int): Future[Int] = repository.share(id)

}
