package domain.lifecycle

case class UserRepositoryRequest(name: String, firebaseUid: String) {
  def genUserName(): String = "@" + this.name
}

case class LiftTypeRepositoryRequest(
    name: String,
    referenceUrl: Option[String],
    description: Option[String],
    userId: Int,
    defaultRep: Int = 0,
    defaultWeight: Int = 0,
    defaultSetCount: Int = 0,
    shareFlag: Boolean = false
)

case class BodyPartRepositoryRequest(name: String, categoryId: Int)

case class TrainingMenuRepositoryRequest(

    name: String,
    description: Option[String],
    userId: Int,
    shareFlag: Boolean = false
)

case class LiftActionRepositoryRequest(

    liftTypeId: Int,
    trainingMenuId: Int,
    lightRep: Int = 0,
    lightWeight: Int = 0,
    lightSetCount: Int = 0,
    heavyRep: Int = 0,
    heavyWeight: Int = 0,
    heavySetCount: Int = 0
)

case class TargetRepositoryRequest(

    liftActionId: Int,
    bodyPartId: Int,
    isMain: Boolean = true
)

case class CategoryRepositoryRequest(

    name: String
)

case class TargetedLiftTypeRequest(
    id: Int,
    lightRep: Int = 0,
    lightWeight: Int = 0,
    lightSetCount: Int = 0,
    heavyRep: Int = 0,
    heavyWeight: Int = 0,
    heavySetCount: Int = 0,
    targetBodyPartIds: List[Int],
    isMain: Int
)