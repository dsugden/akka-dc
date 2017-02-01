import sbt._

object Version {
  val akkaVer         = "2.4.16"
  val scalaVer        = "2.12.1"
  val scalaTestVer    = "3.0.1"

}

object Dependencies {
  val dependencies = Seq(
    "com.typesafe.akka"       %% "akka-actor"                 % Version.akkaVer,
    "com.typesafe.akka"       %% "akka-testkit"               % Version.akkaVer,
    "com.typesafe.akka"       %% "akka-stream"                % Version.akkaVer,
    "com.typesafe.akka"       %% "akka-stream-testkit"        % Version.akkaVer,
    "org.scalatest"           %% "scalatest"                  % Version.scalaTestVer % "test"
  )
}
