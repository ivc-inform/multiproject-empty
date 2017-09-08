import ru.simplesys.sbprocessing.sbtbuild.{CommonDeps, CommonSettings}

name := "multiproject-empty"

lazy val root = (project in file(".")). //enablePlugins(GitVersioning).
  aggregate(common).
  settings(
      inThisBuild(Seq(
          scalaVersion := CommonSettings.settingValues.scalaVersion
      ) ++ CommonSettings.defaultSettings),
      publishArtifact := false,
  )


lazy val common = (project in file("common")).
  settings(
      libraryDependencies ++= Seq(
          CommonDeps.scalaTest % Test
      )
  )

