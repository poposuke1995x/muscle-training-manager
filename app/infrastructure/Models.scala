package infrastructure

import domain.{BodyPart, Category, LiftAction, LiftType, Target, TrainingMenu, User}
import javax.inject.Inject
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import scala.concurrent.ExecutionContext

class Models @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  class BodyPartsTable(tag: Tag) extends Table[BodyPart](tag, "body_parts") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)

    def name = column[String]("name")

    def categoryId = column[Int]("category_id")

    def * = (id, name, categoryId) <> (BodyPart.tupled, BodyPart.unapply)

  }

  class CategoriesTable(tag: Tag) extends Table[Category](tag, "categories") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)

    def name = column[String]("name")

    def * = (id, name) <> (Category.tupled, Category.unapply)
  }

  class LiftActionsTable(tag: Tag) extends Table[LiftAction](tag, "lift_actions") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)

    def liftTypeId = column[Int]("lift_type_id")

    def trainingMenuId = column[Int]("training_menu_id")

    def lightRep = column[Int]("light_rep")

    def lightWeight = column[Int]("light_weight")

    def lightSetCount = column[Int]("light_set_count")

    def heavyRep = column[Int]("heavy_rep")

    def heavyWeight = column[Int]("heavy_weight")

    def heavySetCount = column[Int]("heavy_set_count")

    def * = (
      id,
      liftTypeId,
      trainingMenuId,
      lightRep,
      lightWeight,
      lightSetCount,
      heavyRep,
      heavyWeight,
      heavySetCount,
    ) <> (LiftAction.tupled, LiftAction.unapply)
  }

  class LiftTypesTable(tag: Tag) extends Table[LiftType](tag, "lift_types") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)

    def name = column[String]("name")

    def referenceUrl = column[Option[String]]("reference_url")

    def description = column[Option[String]]("description")

    def importedCount = column[Int]("imported_count")

    def userId = column[Int]("user_id")

    def defaultRep = column[Int]("default_rep")

    def defaultWeight = column[Int]("default_weight")

    def defaultSetCount = column[Int]("default_set_count")

    def shareFlag = column[Boolean]("share_flag")

    def * = (
      id,
      name,
      referenceUrl,
      description,
      importedCount,
      userId,
      defaultRep,
      defaultWeight,
      defaultSetCount,
      shareFlag
    ) <> (LiftType.tupled, LiftType.unapply)
  }

  class TargetsTable(tag: Tag) extends Table[Target](tag, "targets") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)

    def liftActionId = column[Int]("lift_action_id")

    def bodyPartId = column[Int]("body_part_id")

    def isMain = column[Boolean]("is_main")

    def * = (id, liftActionId, bodyPartId, isMain) <> (Target.tupled, Target.unapply)
  }

  class TrainingMenuTable(tag: Tag) extends Table[TrainingMenu](tag, "training_menu") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)

    def name = column[String]("name")

    def categoryId = column[Int]("category_id")

    def description = column[Option[String]]("description")

    def userId = column[Int]("user_id")

    def shareFlag = column[Boolean]("share_flag")

    def * = (
      id,
      name,
      categoryId,
      description,
      userId,
      shareFlag
    ) <> (TrainingMenu.tupled, TrainingMenu.unapply)

  }

  class UsersTable(tag: Tag) extends Table[User](tag, "users") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)

    def name = column[String]("name")

    def firebase_uid = column[String]("firebase_uid")

    def * = (id, name, firebase_uid) <> (User.tupled, User.unapply)
  }

}
