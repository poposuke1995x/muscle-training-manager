package dto

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

case class LiftTypeRequest(
    name: Option[String],
    referenceUrl: Option[Option[String]],
    description: Option[Option[String]],
    defaultRep: Option[Int],
    defaultWeight: Option[Int],
    defaultSetCount: Option[Int],
    shareFlag: Option[Boolean]
)

case class ListMenuLiftTypeRequest(trainingMenuId: Int)

case class TrainingMenuDetailRequest(name: String, description: String)

case class MenuLiftActionRequest(
    id: Int,
    trainingMenuId: Int,
    defaultRep: Int = 0,
    defaultWeight: Int = 0,
    defaultSetCount: Int = 0,
    lightRep: Int = 0,
    lightWeight: Int = 0,
    lightSetCount: Int = 0,
    heavyRep: Int = 0,
    heavyWeight: Int = 0,
    heavySetCount: Int = 0,
    userId: Int = 0,
    name: Option[String]
)