package infrastructure.datasource

import domain.{Category, CategoryRepositoryInterface}
import infrastructure.Models
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class CategoryRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, models: Models)
    (implicit executionContext: ExecutionContext)
    extends HasDatabaseConfigProvider[JdbcProfile] with CategoryRepositoryInterface {

  import profile.api._

  private val Categories = TableQuery[models.CategoriesTable]

  def index(): Future[List[Category]] = db.run(Categories.result).map(_.toList)

  def findById(id: Int): Future[Category] = db.run(Categories.filter(_.id === id).result.head)


}