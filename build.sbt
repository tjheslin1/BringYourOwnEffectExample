import Dependencies._

lazy val root = (project in file(".")).settings(libraryDependencies ++= Seq(

))

scalacOptions += "-Ypartial-unification"