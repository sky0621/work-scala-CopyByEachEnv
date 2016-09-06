name := "work-scala-CopyByEachEnv"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" %  "1.0.1",
  "com.typesafe.akka" %% "akka-actor" % "2.4.2",
  "com.github.scala-incubator.io" % "scala-io-core_2.11" % "0.4.3-1",
  "com.github.scala-incubator.io" % "scala-io-file_2.11" % "0.4.3-1"
)
