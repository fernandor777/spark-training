name := "ratingsCount"

version := "0.1"

organization := "com.fmino"

scalaVersion := "2.12.9"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.4.3"
)

libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.8" % "test"