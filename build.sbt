import Dependencies._

lazy val root = (project in file("."))
  .settings(
    organization in ThisBuild := "elephants",
    scalaVersion in ThisBuild := "2.12.6",
    version      in ThisBuild := "0.1.0-SNAPSHOT",
    name := "elephants",
    libraryDependencies += scalaTest % Test
  )
