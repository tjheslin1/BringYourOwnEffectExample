import sbt._

object Dependencies {

  val catsVersion = "1.0.0-RC1"
  val circeVersion = "0.9.3"

  val cats = "org.typelevel" %% "cats-core" % catsVersion

  val circe = Seq(
    "io.circe" %% "circe-core",
    "io.circe" %% "circe-generic",
    "io.circe" %% "circe-parser"
  ).map(_ % circeVersion)

  val scalatest = "org.scalatest" %% "scalatest" % "3.0.1" % Test
}