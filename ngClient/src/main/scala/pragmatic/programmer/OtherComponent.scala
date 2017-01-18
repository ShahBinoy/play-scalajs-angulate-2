package pragmatic.programmer

import angulate2.ext.tags.simple._
import angulate2.std._
import com.washingtonpost.identity.csr.model.Profile

import scala.scalajs.js
import scalatags.Text.all._

@Component(
  selector = "other-app",
  styleUrls = js.Array("assets/app.component.css"),
  template = tpl(
    div()(
      button(`type`:= "submit", ngClick := "click()")("Submit"),
      hr(size := "2"),
      div(ngIf := "isAdmin")(
        hr(size := "2"),
        h3("Hello Other world {{title}} ")
      )
    )
  )
)
class OtherComponent {
  val title = "Test Other App"
  var isAdmin = true

  def click(profile: Profile): Unit = {
    isAdmin = true
  }
}
