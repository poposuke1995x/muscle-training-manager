package domain

//Todo: Value Objectの導入

case class User(id: Option[Int], name: String, firebaseUid: String) {
  def genUserName (): String = "@" + this.name
}

case class LiftType(
                     id: Option[Int],
                     name: String,
                     referenceUrl: Option[String],
                     description: Option[String],
                     importedCount: Int = 0,
                     serverUid: String,
                     defaultRep: Int = 0,
                     defaultWeight: Int = 0,
                     defaultSetCount: Int = 0,
                     shareFlag: Boolean = false
                   )

case class BodyPart(id: Option[Int], name: String)

case class TrainingMenu(
                         id: Option[Int],
                         name: String,
                         categoryId: Int,
                         description: Option[String],
                         importedCount: Int = 0,
                         userUid: String,
                         shareFlag: Boolean = false
                       )

case class LiftAction(
                       id: Option[Int],
                       liftTypeId: Int,
                       trainingMenuId: Int,
                       lightRep: Int = 0,
                       lightWeight: Int = 0,
                       lightSetCount: Int = 0,
                       heavyRep: Int = 0,
                       heavyWeight: Int = 0,
                       heavySetCount: Int = 0,
//                       userUid: String,
                     )

case class Target(
                   id: Option[Int],
                   liftActionId: Int,
                   bodyPartId: Int,
                   isMain: Boolean = true
                 )

case class Category(
                     id: Option[Int],
                     name: String
                   )