name := "SparkExperiments"

useCoursier := false

version := "1.1"

//scalaVersion := "2.10.4"
scalaVersion := "2.12.17"

//val sparkVersion = "1.3.1"
val sparkVersion = "3.4.0"

val sparkCore = "org.apache.spark" %% "spark-core" % sparkVersion
val sparkSql = "org.apache.spark" %% "spark-sql" % sparkVersion
val sparkCsv = "org.apache.spark" %% "spark-csv" % sparkVersion
val sparkStreaming = "org.apache.spark" %% "spark-streaming" % sparkVersion
val commonsIo = "commons-io"          %  "commons-io"           % "2.14.0"
val scopt = "com.github.scopt"        %% "scopt"                % "3.7.1"

// val jackson = "com.fasterxml.jackson.core" % "jackson-core" % "2.14.2"

// Add comment for check "Dependency graph" availability 
resolvers ++= Seq(
  Resolver.sonatypeRepo("release"),
  Resolver.sonatypeRepo("public"),
  Resolver.mavenLocal,
  "Typesafe Releases" at "https://repo.typesafe.com/typesafe/maven-releases/"
)

libraryDependencies ++=
  ( Seq( sparkCore, sparkSql, sparkStreaming ) map { _ % "provided" } ) ++
  Seq(
    "org.scalatest" %% "scalatest" % "3.0.9" % "test",
    commonsIo,
    scopt,
    "commons-lang" % "commons-lang" % "2.6"
  )

test in assembly := {}

// Errors creating spark contexts otherwise
parallelExecution in Test := false
