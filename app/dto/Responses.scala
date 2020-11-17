package dto

case class LiftTypesInTrainingMenuRequest(
    id: Option[Int],
    name: String,
    description: Option[String],
    userId: Int,
    defaultRep: Int = 0,
    defaultWeight: Int = 0,
    defaultSetCount: Int = 0,
    lightRep: Int = 0,
    lightWeight: Int = 0,
    lightSetCount: Int = 0,
    heavyRep: Int = 0,
    heavyWeight: Int = 0,
    heavySetCount: Int = 0,
)
