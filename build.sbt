// Versions
name    := "scala-databricks-env"
version := "1.0"

scalaVersion := "2.13.16"
scalacOptions ++= Seq("-feature", "-language:reflectiveCalls")

val sparkVersion = "4.0.0"
val deltaVersion = "4.0.0"

// Dependencies
libraryDependencies ++= Seq(
  "org.apache.spark"    %% "spark-core"       % sparkVersion % Provided,
  "org.apache.spark"    %% "spark-sql"        % sparkVersion % Provided,
  "io.delta"            %% "delta-spark"      % deltaVersion % Provided,
  "org.scalactic"       %% "scalactic"        % "3.2.19",
  "org.scalatest"       %% "scalatest"        % "3.2.19"     % Test,
  "org.scalamock"       %% "scalamock"        % "7.5.5"      % Test,
  "com.github.mrpowers" %% "spark-fast-tests" % "3.0.2"      % Test
)
