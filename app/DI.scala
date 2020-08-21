import com.google.inject.AbstractModule
import domain.repositories.LiftTypeRepositoryInterface

class DI extends AbstractModule {
  override def configure(): Unit = {

    bind(classOf[LiftTypeRepositoryInterface]).to(classOf[infrastructure.LiftTypeRepository])

  }
}
