package pragmatic.programmer

import angulate2.std._
import angulate2.ext.tags.simple._
import angulate2.router.{ActivatedRoute, Router}
import com.washingtonpost.identity.csr.model.Profile
import com.washingtonpost.identity.csr.security.Config
import org.scalajs.dom.svg.View
import rxjs.{RxPromise, ValOrObs}


import scalatags.Text.all._
import scala.scalajs.js

@Component(
  selector = "main-app",
  styleUrls = js.Array("assets/app.component.css"),
  template = tpl(
    div()(
      button(`type` := "submit", ngClick := "click()")("Submit"),
      hr(size := "2"),
      div(ngIf := "user.isAdmin")(
        hr(size := "2"),
        h3("Hello world {{title}} User is Admin")
      ),
      div( ngIf := "user.isAgent")(
        h1("Huh .. Just an agent {{title}}")
      ),
      div( ngIf := "user.isSuper")(
        h1("Whoa.. I am a Super {{title}}")
      )
    )
  )
)
class MainComponent(val user: CurrentUser) {
  var title = "Test App"

  def click(): Unit = {
    title = s"Clicked !! ${user.isAdmin}"
  }


}
