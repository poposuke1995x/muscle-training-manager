package domain

case class Id(id: Int) {val value = id}
case class AutoIncId(id: Option[Int]) {val value = id}
case class FirebaseUid(id: String) {val value = id}
case class Name(name: String) {val value = name}
case class UserName(inputName: String) {
  val value = "@" + inputName
}
case class Description(inputDescription: String)
case class Rep(rep: Int)
case class Weight(weight: Int)
case class SetCount(setCount: Int)


