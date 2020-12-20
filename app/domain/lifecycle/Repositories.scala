package domain.lifecycle

import domain._
import usecase.dto._

import scala.concurrent.Future


trait BodyPartRepositoryInterface {
  def index(): Future[List[BodyPart]]
}

trait CategoryRepositoryInterface {
  def index(): Future[List[Category]]
  def findById(id: Int): Future[Option[Category]]
}

trait LiftActionRepositoryInterface {
  def index(): Future[Seq[LiftAction]]

  def findById(id: Int): Future[Option[LiftAction]]

  def findByForeignKeyId(liftTypeId: Int, menuId: Int): Future[Option[LiftAction]]

  def insert(liftAction: LiftAction): Future[Option[LiftAction]]

  def update(liftAction: LiftAction): Future[Option[LiftAction]]

  def delete(id: Int): Future[Boolean]
}

trait LiftTypeRepositoryInterface {
  def index(): Future[List[LiftType]]

  def findById(id: Int): Future[Option[LiftType]]

  def findByUserId(userId: Int): Future[List[LiftType]]

  def insert(liftType: LiftType): Future[Option[LiftType]]

  def update(liftType: LiftType): Future[Option[LiftType]]

  def updateDefaultAction(
      liftTypeId: Int,
      defaultRep: Int,
      defaultSetCount: Int,
      defaultWeight: Int): Future[Option[(Int, Int, Int, Int)]]

  def share(liftTypeId: Int): Future[Int]

  def delete(id: Int): Future[Boolean]
}

trait TrainingMenuRepositoryInterface {
  def index(): Future[List[TrainingMenu]]

  def findById(id: Int): Future[Option[TrainingMenu]]

  def findByUserId(userId: Int): Future[List[TrainingMenu]]

  def insert(trainingMenu: TrainingMenu): Future[Option[TrainingMenu]]

  def update(trainingMenu: TrainingMenu): Future[Option[TrainingMenu]]

  def delete(id: Int): Future[Boolean]
}

trait UserRepositoryInterface {
  def findIdByUid(uid: String): Future[Option[Int]]
  def insert(user: User): Future[Option[User]]
//  def update(user: User): Future[Option[User]]
//  def delete(id: Int): Future[Boolean]
}

trait RegisterLiftTypesToTrainingMenuRepositoryInterface {
  def execute(trainingMenuId: Int, req: List[TargetedLiftTypeRequest]): Future[List[Int]]
}

trait DeleteLiftTypesFromTrainingMenuRepositoryInterface {
  def execute(trainingMenuId: Int, liftTypeIds: List[Int]): Future[Boolean]
}

trait ListLiftTypeRepositoryInterface {
  def execute(bodyPartId: Option[Int]): Future[Seq[LiftType]]
}

trait ListMenuLiftTypeRepositoryInterface {
  def execute(trainingMenuId: Int, bodyPartId: Option[Int]): Future[(Seq[LiftType], Seq[LiftAction])]
}
