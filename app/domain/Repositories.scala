package domain

import scala.concurrent.Future
import dto._


trait BodyPartRepositoryInterface {
  def index(): Future[List[BodyPart]]
}

trait CategoryRepositoryInterface {
  def index(): Future[List[Category]]
  def findById(id: Int): Future[Category]
}

trait LiftActionRepositoryInterface {
  def index(): Future[Seq[LiftAction]]

  def findById(id: Int): Future[LiftAction]

  def insert(liftAction: LiftAction): Future[Int]

  def update(liftAction: LiftAction): Future[Int]

  def delete(id: Int): Future[Int]
}

trait LiftTypeRepositoryInterface {
  def index(): Future[Seq[LiftType]]

  def findById(id: Int): Future[LiftType]

  def findByUserId(userId: Int): Future[Seq[LiftType]]

  def insert(liftType: LiftType): Future[Int]

  def update(liftType: LiftType): Future[Int]

  def share(liftTypeId: Int): Future[Int]

  def delete(id: Int): Future[Int]
}

trait TargetRepositoryInterface {
  def index(): Future[Seq[Target]]

  def findById(id: Int): Future[Target]

  def insert(target: Target): Future[Int]

  def updateIsMain(id: Int, isMain: Boolean): Future[Int]

  def delete(id: Int): Future[Int]
}

trait TrainingMenuRepositoryInterface {
  def index(): Future[Seq[TrainingMenu]]

  def findById(id: Int): Future[TrainingMenu]

  def findByUserId(userId: Int, categoryId: Option[Int]): Future[Seq[TrainingMenu]]

  def insert(trainingMenu: TrainingMenu): Future[Int]

  def update(trainingMenu: TrainingMenu): Future[Int]

  def delete(id: Int): Future[Int]
}

trait UserRepositoryInterface {
  def index(): Future[Seq[User]]
  def findById(id: Int): Future[User]
  def findIdByUid(uid: String): Future[Int]
  def insert(user: User): Future[Int]
  def update(user: User): Future[Int]
  def delete(id: Int): Future[Int]
}

trait RegisterLiftTypesToTrainingMenuRepositoryInterface {
  def execute(trainingMenuId: Int, req: RegisterLiftTypesToTrainingMenuRequest): List[Future[Int]]
}

trait DeleteLiftTypesFromTrainingMenuRepositoryInterface {
  def execute(trainingMenuId: Int, liftTypeIds: List[Int]): Future[Int]
}

trait ListLiftTypeRepositoryInterface {
  def execute(bodyPartId: Option[Int]): Future[Seq[LiftType]]
}

trait ListMenuLiftTypeRepositoryInterface {
  def execute(trainingMenuId: Int, bodyPartId: Option[Int]): Future[Seq[LiftType]]
}

trait UpdateTrainingActionRepositoryInterface {
  def execute(actions: List[LiftAction]): Future[Int]
}