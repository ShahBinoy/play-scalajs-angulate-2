import Angulate2Plugin._
import sbt.Keys._
import sbt.Project.projectToRef
import Settings.jsDependencies


name in ThisBuild := """play-scalajs-angulate-2"""

scalaVersion in ThisBuild := "2.11.8"

lazy val commonSettings = Seq(
  organization := "pragmatic",
  version := "0.0.1",
  scalacOptions ++= Seq("-deprecation","-unchecked","-feature","-Xlint", "-Xfatal-warnings"),
  resolvers += Resolver.sonatypeRepo("snapshots"),
  publish := {},
  publishLocal := {}
)

lazy val server = project.in(file("server")).
  enablePlugins(PlayScala, SbtWeb).
  settings(commonSettings: _*).
  settings(
    compile in Compile <<= (compile in Compile) dependsOn (fastOptJS in (ngClient, Compile)),
    unmanagedResources in Assets += baseDirectory.value / "../ngClient/target/scala-2.11/ngclient-sjsx.js",
    unmanagedResources in Assets += baseDirectory.value / "../ngClient/target/scala-2.11/ngclient-fastopt.js",
    scalaJSProjects := Seq(ngClient),
    routesGenerator := InjectedRoutesGenerator,
    pipelineStages in Assets := Seq(scalaJSPipeline),
    libraryDependencies ++= Seq(
      "com.softwaremill.macwire" %% "macros" % "2.2.2" % "provided",
      "com.lihaoyi" %% "scalatags" % "0.6.2"
    )
  ).
  aggregate(Project.projectToRef(ngClient)).
  dependsOn(sharedJvm)

lazy val ngClient = project.in(file("ngClient")).
  settings(commonSettings: _*).
  enablePlugins(Angulate2Plugin, ScalaJSPlugin, ScalaJSWeb).
  dependsOn(sharedJs).
  settings(
    scalaJSOutputMode := org.scalajs.core.tools.linker.backend.OutputMode.ECMAScript6,
    relativeSourceMaps := true,
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.9.0",
      "com.github.karasiq" %%% "scalajs-bootstrap" % "1.1.2",
      "com.lihaoyi" %%% "scalatags" % "0.6.2",
      "biz.enef" %%% "slogging" % "0.5.2"
    ),
    ngBootstrap := Some("pragmatic.programmer.AppModule")
  )

lazy val shared = (crossProject.crossType(CrossType.Pure) in file("shared")).
  settings(commonSettings: _*).
  jsConfigure(_ enablePlugins ScalaJSWeb)

lazy val sharedJvm = shared.jvm

lazy val sharedJs = shared.js
