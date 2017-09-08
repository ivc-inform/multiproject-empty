import ru.simplesys.sbprocessing.sbtbuild.{CommonDeps, CommonSettings}

name := "multiproject-empty"

lazy val root = (project in file(".")).
  enablePlugins(GitVersioning).
  aggregate(common).
  settings(
      inThisBuild(Seq(
          scalaVersion := CommonSettings.settingValues.scalaVersion
      )
        ++ CommonSettings.defaultSettings),
      publishArtifact in(Compile, packageBin) := false,
      publishArtifact in(Compile, packageDoc) := false,
      publishArtifact in(Compile, packageSrc) := false
  )

lazy val common = (project in file("common")).
  settings(
      libraryDependencies ++= Seq(
          CommonDeps.scalaTest % Test
      )
  ).settings(CommonSettings.defaultProjectSettings)

