name := """form"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  javaJpa
)

libraryDependencies += "org.postgresql" % "postgresql" % "9.3-1102-jdbc4"

libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "4.3.6.Final"

libraryDependencies ++= Seq(
  "org.webjars" %% "webjars-play" % "2.3.0",
  "org.webjars" % "bootstrap" % "3.2.0",
  "org.webjars" % "jquery" % "2.1.1"
)
