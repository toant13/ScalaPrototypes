import _root_.sbtassembly.AssemblyPlugin.autoImport._

name := "Thor_HTTP4s"

version := "1.0"

scalaVersion := "2.10.4"


libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.5.2",
  "org.http4s" %% "http4s-blaze-server" % "0.11.0",
  "org.http4s" %% "http4s-dsl" % "0.11.0",
  "org.http4s" %% "http4s-argonaut" % "0.11.0",
  "org.json4s" %% "json4s-native" % "3.3.0"
)

//"org.slf4j" % "slf4j-simple" % "1.7.16"

assemblyMergeStrategy in assembly := {
  case m if m.toLowerCase.endsWith("manifest.mf") => MergeStrategy.discard
  case m if m.toLowerCase.matches("meta-inf.*\\.sf$") => MergeStrategy.discard
  case "reference.conf" => MergeStrategy.concat
  case _ => MergeStrategy.first
}