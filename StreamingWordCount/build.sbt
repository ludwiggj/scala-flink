name := "flink-demo-wordcount"

organization := "com.bt.ludwiggj"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
   "org.apache.flink" %% "flink-streaming-scala"  % "1.2.1",
   "org.apache.flink" %% "flink-clients"          % "1.2.1"
)