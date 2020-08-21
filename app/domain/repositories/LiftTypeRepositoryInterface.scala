package domain.repositories

import domain.LiftType
import scala.concurrent.Future

trait LiftTypeRepositoryInterface {
  def index(): Future[Seq[LiftType]]

  def findById(id: Int): Future[LiftType]

  def insert(liftType: LiftType): Future[Int]

  def update(liftType: LiftType): Future[Int]

  def delete(id: Int): Future[Int]
}
