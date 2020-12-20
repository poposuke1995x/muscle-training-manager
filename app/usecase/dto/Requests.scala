package usecase.dto

import scala.util.matching.Regex

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

case class UpdatePasswordRequest(newPassword: String, confirmPassword: String) {
  def validate: Either[String, String] = {
    val matchPattern: Regex = "^(?=.*[a-z])(?=.*[0-9])[a-zA-Z0-9!\"#$%&'()\\-^@;:,./|`{+*}<>?_]{8,32}$".r
    newPassword match {
      case newPassword if newPassword != confirmPassword => Left("パスワードと確認用パスワードが不一致です")
      case matchPattern() => Right(newPassword)
      case _ => Left("パスワードは8~32文字の半角英数字と記号を組み合わせて指定してください")
    }
  }
}