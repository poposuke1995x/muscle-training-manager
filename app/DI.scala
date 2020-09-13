import com.google.inject.AbstractModule
import domain._

class DI extends AbstractModule {
  override def configure(): Unit = {

    bind(classOf[BodyPartRepositoryInterface]).to(classOf[infrastructure.BodyPartRepository])
    bind(classOf[CategoryRepositoryInterface]).to(classOf[infrastructure.CategoryRepository])
    bind(classOf[LiftActionRepositoryInterface]).to(classOf[infrastructure.LiftActionRepository])
    bind(classOf[LiftTypeRepositoryInterface]).to(classOf[infrastructure.LiftTypeRepository])
    bind(classOf[TargetRepositoryInterface]).to(classOf[infrastructure.TargetRepository])
    bind(classOf[TrainingMenuRepositoryInterface]).to(classOf[infrastructure.TrainingMenuRepository])
    bind(classOf[UserRepositoryInterface]).to(classOf[infrastructure.UserRepository])
    bind(classOf[RegisterLiftTypesToTrainingMenuRepositoryInterface]).to(classOf[infrastructure.RegisterLiftTypesToTrainingMenuRepository])
    bind(classOf[DeleteLiftTypesFromTrainingMenuRepositoryInterface]).to(classOf[infrastructure.DeleteLiftTypesFromTrainingMenuRepository])
  }
}
