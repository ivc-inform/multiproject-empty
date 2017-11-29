import sbtcrossproject.{CrossType, crossProject}

lazy val root = crossProject(JSPlatform, JVMPlatform)
  .settings(CommonSettings.noPublishSettings)
  .settings(
      inThisBuild(Seq(
          scalaVersion := CommonSettings.settingValues.scalaVersion,
          scalacOptions := CommonSettings.settingValues.scalacOptions,
          organization := CommonSettings.settingValues.organization
      ) ++ CommonSettings.defaultSettings)
  )
  .aggregate(ganttImproved)
  .dependsOn(ganttImproved)

lazy val ganttImproved = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .settings(CommonSettings.publishSettings)
  .settings(
      name := "jsgantt-improved"
  )
  .settings(CommonSettings.defaultSettings)
  .jvmSettings(
      libraryDependencies ++= Seq(
          "org.scalatest" %% "scalatest" % "3.0.4" % Test
      )
  )
  .jsSettings(
      crossTarget in fastOptJS := (sourceDirectory in Compile).value / "javascriptJS",
      crossTarget in fullOptJS := (sourceDirectory in Compile).value / "javascriptJS",
      crossTarget in packageJSDependencies := (sourceDirectory in Compile).value / "javascriptJS",
      libraryDependencies ++= Seq(
          "org.scalatest" %%% "scalatest" % "3.0.4" % Test
      ),
      scalacOptions ++= {
          if (scalaJSVersion.startsWith("0.6."))
              Seq("-P:scalajs:sjsDefinedByDefault")
          else
              Nil
      }
  )

lazy val ganttImprovedJS = ganttImproved.js
lazy val ganttImprovedJVM = ganttImproved.jvm





