import com.google.inject.AbstractModule
import domain.lifecycle._
import infrastructure.composite.{DeleteLiftTypesFromTrainingMenuRepository, ListLiftTypeRepository, ListMenuLiftTypeRepository, RegisterLiftTypesToTrainingMenuRepository}

class DI extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[BodyPartRepositoryInterface]).to(classOf[infrastructure.BodyPartRepository])
    bind(classOf[CategoryRepositoryInterface]).to(classOf[infrastructure.CategoryRepository])
    bind(classOf[LiftActionRepositoryInterface]).to(classOf[infrastructure.LiftActionRepository])
    bind(classOf[LiftTypeRepositoryInterface]).to(classOf[infrastructure.LiftTypeRepository])
    bind(classOf[TrainingMenuRepositoryInterface]).to(classOf[infrastructure.TrainingMenuRepository])
    bind(classOf[UserRepositoryInterface]).to(classOf[infrastructure.UserRepository])
    bind(classOf[RegisterLiftTypesToTrainingMenuRepositoryInterface]).to(classOf[RegisterLiftTypesToTrainingMenuRepository])
    bind(classOf[DeleteLiftTypesFromTrainingMenuRepositoryInterface]).to(classOf[DeleteLiftTypesFromTrainingMenuRepository])
    bind(classOf[ListLiftTypeRepositoryInterface]).to(classOf[ListLiftTypeRepository])
    bind(classOf[ListMenuLiftTypeRepositoryInterface]).to(classOf[ListMenuLiftTypeRepository])
  }
}
