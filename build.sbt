name := "QuillSample"

version := "1.0"

scalaVersion := "2.11.8"

resolvers ++= Seq(
   Resolver.sonatypeRepo("snapshots")
)

libraryDependencies ++= Seq(
   "io.getquill" %% "quill-cassandra" % "1.0.1-SNAPSHOT",
   "io.getquill" % "quill-core_2.11" % "0.3.0",
   "com.google.code.findbugs" % "jsr305" % "3.0.1"
)