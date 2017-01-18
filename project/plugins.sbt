resolvers += Resolver.sonatypeRepo("snapshots")

resolvers += "Typesafe repository" at "https://repo.typesafe.com/typsesafe/releases/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.10")

addSbtPlugin("com.vmunier" % "sbt-web-scalajs" % "1.0.1")

addSbtPlugin("de.surfice" % "sbt-angulate2" % "0.0.5")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.13")
