import sbtcrossproject.{CrossType, crossProject}

lazy val root = crossProject(JSPlatform, JVMPlatform)
  .settings(CommonSettings.noPublishSettings)
  .settings(
      inThisBuild(Seq(
          scalaVersion := CommonSettings.settingValues.scalaVersion,
          scalacOptions := CommonSettings.settingValues.scalacOptions,
          organization := CommonSettings.settingValues.organization,
          name := CommonSettings.settingValues.name
      ) ++ CommonSettings.defaultSettings)
  )
  .aggregate(anyName)
  .dependsOn(anyName)

lazy val anyName = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .settings(CommonSettings.publishSettings)
  .settings(
      name := "no-name"
  )
  .settings(CommonSettings.defaultSettings)
  .jvmSettings(
      libraryDependencies ++= Seq(
          CommonDeps.scalaTest % Test
      )
  )
  .jsSettings(
      crossTarget in fastOptJS := (sourceDirectory in Compile).value / ".." / ".." / ".." / ".jvm" / "src" / "main" / "webapp" / "javascript" / "generated" / "generatedComponentsJS",
      crossTarget in fullOptJS := (sourceDirectory in Compile).value / ".." / ".." / ".." / ".jvm" / "src" / "main" / "webapp" / "javascript" / "generated" / "generatedComponentsJS",
      crossTarget in packageJSDependencies := (sourceDirectory in Compile).value / ".." / ".." / ".." / ".jvm" / "src" / "main" / "webapp" / "javascript" / "generated" / "generatedComponentsJS",
      libraryDependencies ++= Seq(
          CommonDepsScalaJS.scalaTest.value,
      ),
      scalacOptions ++= {
          if (scalaJSVersion.startsWith("0.6.")) Seq("-P:scalajs:sjsDefinedByDefault") else Nil
      }
  )

lazy val noNameJS = anyName.js
lazy val noNameJVM = anyName.jvm





