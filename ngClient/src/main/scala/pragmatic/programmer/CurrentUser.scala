package pragmatic.programmer

import angulate2.std.Injectable
import com.washingtonpost.identity.csr.security.Config

/**
  * Created by shahb on 1/17/17.
  */
@Injectable
class CurrentUser {

  val isAdmin = Config.hasPermission("admin")
  val isAgent = Config.hasPermission("agent")
  val isSuper = Config.hasPermission("super")
}

