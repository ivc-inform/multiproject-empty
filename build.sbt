import com.typesafe.sbt.SbtGit.git
import ru.simplesys.sbprocessing.sbtbuild.{CommonDeps, CommonSettings}

name := "unknown"

lazy val root = (project in file(".")).
  enablePlugins(GitVersioning).
  aggregate(common, core).
  settings(
      inThisBuild(Seq(
          git.baseVersion := CommonSettings.settingValues.baseVersion,
          scalaVersion := CommonSettings.settingValues.scalaVersion,
          publishTo := {
              val corporateRepo = "http://toucan.simplesys.lan/"
              if (isSnapshot.value)
                  Some("snapshots" at corporateRepo + "artifactory/libs-snapshot-local")
              else
                  Some("releases" at corporateRepo + "artifactory/libs-release-local")
          },
          credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
      )
        ++ CommonSettings.defaultSettings),
      publishArtifact in(Compile, packageBin) := false,
      publishArtifact in(Compile, packageDoc) := false,
      publishArtifact in(Compile, packageSrc) := false
  )

lazy val common = (project in file("common")).
  settings(
      libraryDependencies ++= Seq(
          CommonDeps.logging.value,
          CommonDeps.scalaTest.value % Test
      )
  ).settings(CommonSettings.defaultProjectSettings)

lazy val core = (project in file("core")).dependsOn(common).
  settings(
      libraryDependencies ++= Seq(
          CommonDeps.scalaTest.value % Test
      )
  ).settings(CommonSettings.defaultProjectSettings)
