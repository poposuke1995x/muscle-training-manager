package infrastructure

import scala.concurrent.{ExecutionContext, Future}
import javax.inject.Inject
import domain.{Category, CategoryRepositoryInterface}
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

class CategoryRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, models: Models)
    (implicit executionContext: ExecutionContext)
    extends HasDatabaseConfigProvider[JdbcProfile] with CategoryRepositoryInterface {

  import profile.api._

  private val Categories = TableQuery[models.CategoriesTable]

  def index(): Future[List[Category]] = db.run(Categories.result).map(_.toList)

  def findById(id: Int): Future[Category] = db.run(Categories.filter(_.id === id).result.head)


}