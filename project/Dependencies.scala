import sbt._

object Dependencies {

  val catsVersion = "1.0.0-RC1"

  val cats = "org.typelevel" %% "cats-core" % catsVersion

  val scalatest = "org.scalatest" %% "scalatest" % "3.0.1" % Test
}