package infrastructure

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import domain.Category
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

class CategoryRepository @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  private val Categories = TableQuery[CategoriesTable]

  def index(): Future[Seq[Category]] = db.run(Categories.result)
  def findById(id: Int): Future[Category] = db.run(Categories.filter(_.id === id).result.head)

  private class CategoriesTable(tag: Tag) extends Table[Category](tag, "categories") {

    def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")

    def * = (id, name) <> (Category.tupled, Category.unapply)
  }
}