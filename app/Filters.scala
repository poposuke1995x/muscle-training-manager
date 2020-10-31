import com.google.inject.Inject
import play.api.http.HttpFilters
import filters.AuthFilter
import play.filters.cors.CORSFilter

class Filters @Inject()(authFilter: AuthFilter, corsFilter: CORSFilter) extends HttpFilters {
  val filters = Seq(
    authFilter,
    corsFilter
  )
}
