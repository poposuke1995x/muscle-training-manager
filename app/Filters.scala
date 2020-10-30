import com.google.inject.Inject
import play.api.http.HttpFilters
import filters.AuthFilter

class Filters @Inject()(authFilter: AuthFilter) extends HttpFilters {
  val filters = Seq()
}
