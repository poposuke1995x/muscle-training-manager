package modules

import java.io.{FileInputStream, InputStream}

import javax.inject._
import play.api.Environment
import play.api.db.evolutions._
import play.api.inject._

class EvolutionsModule extends SimpleModule(
  bind[EvolutionsConfig].toProvider[DefaultEvolutionsConfigParser],
  bind[EvolutionsReader].to[CustomEvolutionsReader],
  bind[EvolutionsApi].to[DefaultEvolutionsApi],
  bind[ApplicationEvolutions].toProvider[ApplicationEvolutionsProvider]
)

@Singleton
class CustomEvolutionsReader @Inject()(environment: Environment) extends ResourceEvolutionsReader {
  override def loadResource(db: String, revision: Int): Option[InputStream] = {
    val evolutionDirectory = environment.getFile(Evolutions.directoryName(db))
    evolutionDirectory.listFiles()
        .find(f => f.getName.endsWith(".sql") && f.getName.startsWith(s"${revision}_"))
        .map(new FileInputStream(_))
  }
}