val scala3Version = "3.0.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "shopping-cart",
    version := "1.0",
    scalaVersion := scala3Version,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test
  )
