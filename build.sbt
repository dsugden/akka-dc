parallelExecution in GlobalScope := false

lazy val base = (project in file("."))
  .aggregate(
    common,
    exercise_007_fusion
 )
  .settings(CommonSettings.commonSettings: _*)

lazy val common = project.settings(CommonSettings.commonSettings: _*)

lazy val exercise_007_fusion = project
  .settings(CommonSettings.commonSettings: _*)
  .dependsOn(common % "test->test;compile->compile")

