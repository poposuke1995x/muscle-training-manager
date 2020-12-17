import com.google.inject.AbstractModule
import domain._
import infrastructure.composite.{DeleteLiftTypesFromTrainingMenuRepository, ListLiftTypeRepository, ListMenuLiftTypeRepository, RegisterLiftTypesToTrainingMenuRepository}
import infrastructure.datasource.{BodyPartRepository, CategoryRepository, LiftActionRepository, LiftTypeRepository, TargetRepository, TrainingMenuRepository, UserRepository}

class DI extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[BodyPartRepositoryInterface]).to(classOf[BodyPartRepository])
    bind(classOf[CategoryRepositoryInterface]).to(classOf[CategoryRepository])
    bind(classOf[LiftActionRepositoryInterface]).to(classOf[LiftActionRepository])
    bind(classOf[LiftTypeRepositoryInterface]).to(classOf[LiftTypeRepository])
    bind(classOf[TargetRepositoryInterface]).to(classOf[TargetRepository])
    bind(classOf[TrainingMenuRepositoryInterface]).to(classOf[TrainingMenuRepository])
    bind(classOf[UserRepositoryInterface]).to(classOf[UserRepository])
    bind(classOf[RegisterLiftTypesToTrainingMenuRepositoryInterface]).to(classOf[RegisterLiftTypesToTrainingMenuRepository])
    bind(classOf[DeleteLiftTypesFromTrainingMenuRepositoryInterface]).to(classOf[DeleteLiftTypesFromTrainingMenuRepository])
    bind(classOf[ListLiftTypeRepositoryInterface]).to(classOf[ListLiftTypeRepository])
    bind(classOf[ListMenuLiftTypeRepositoryInterface]).to(classOf[ListMenuLiftTypeRepository])
  }
}
