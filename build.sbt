name := "scala-examples"
organization := "com.example"
version := "0.1"

scalaVersion := "2.12.6"

// PROJECTS

lazy val root = project.in(file("."))
    .aggregate(typeclass)
    .settings(
      commonSettings,
      publishArtifact := false
    )

lazy val typeclass = (project in file("typeclass"))
  .settings(
    name := "typeclass-examples",
    commonSettings,
    libraryDependencies ++= commonDependencies ++ Seq(
    )
  )

// SETTINGS

lazy val commonSettings = Seq(
  scalacOptions ++= compilerOptions
)

lazy val dependencies =
  new {
    val logback = "ch.qos.logback" % "logback-classic" % "1.2.3"
    val scalatest = "org.scalatest" %% "scalatest" % "3.0.4"
    val `mockito-core` = "org.mockito" % "mockito-core" % "2.23.0"
  }

lazy val commonDependencies = Seq(
  dependencies.logback,
  dependencies.scalatest % "test",
  dependencies.`mockito-core` % "test"
)

lazy val compilerOptions = Seq(
  "-unchecked",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:postfixOps",
  "-deprecation",
  "-encoding",
  "utf8"
)
