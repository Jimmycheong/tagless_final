name := "tagless_final"

version := "0.1"

scalaVersion := "2.12.0"

scalacOptions += "-Ypartial-unification"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "1.6.0"
)
