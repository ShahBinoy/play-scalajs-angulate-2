package views

import controllers.routes

/**
  * Created by shahb on 1/17/17.
  */
object IndexView {

  import scalatags.Text.all._

  def apply(permissions: String) = {
    val userCreds = Seq("admin","agent","super")
    html(
      head()(
        meta(name := "viewport", content := "width=device-width, initial-scale=1"),
        script(src := "https://unpkg.com/core-js@2.4.1/client/shim.min.js"),
        script(src := "https://unpkg.com/zone.js@0.6.26/dist/zone.min.js"),
        script(src := "https://unpkg.com/reflect-metadata@0.1.9/Reflect.js"),
        script(src := "https://unpkg.com/systemjs@0.19.41/dist/system.js"),
        script(src := routes.Assets.versioned("system.config.js").url),
        script()(
          s"window.userPerms = new Array(${permissions});",
          "console.log('Initialized Array');"
        ),
        script()(
          "System.import('app').catch(function(err){ console.error(err); });"
        )
      ),
      body()(
        tag("main-app")("Loading as scalatags....")
        //,tag("other-app")("Loading other app as scalatags....")
      )

    )
  }
}
