name := """muscle-training-manager"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.3"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies ++= Seq(
  filters,
  "com.google.firebase" % "firebase-admin" % "6.8.1",
  "org.json4s" %% "json4s-native" % "3.6.9",
  "org.postgresql" % "postgresql" % "42.2.9",
  "com.typesafe.play" %% "play-slick" % "5.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0"
)
