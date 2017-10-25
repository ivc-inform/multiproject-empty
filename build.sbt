import ru.simplesys.sbprocessing.sbtbuild.{CommonDeps, CommonSettings}
import sbt.{Credentials, Path}

name := "multiproject-empty"

lazy val root = (project in file("."))
  .enablePlugins(GitVersioning)
  .aggregate(common)
  .settings(
      inThisBuild(Seq(
          scalaVersion := CommonSettings.settingValues.scalaVersion,
          publishTo := {
              val corporateRepo = "http://toucan.simplesys.lan/"
              if (isSnapshot.value)
                  Some("snapshots" at corporateRepo + "artifactory/libs-snapshot-local")
              else
                  Some("releases" at corporateRepo + "artifactory/libs-release-local")
          },
          credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
      ) ++ CommonSettings.defaultSettings),
      publishArtifact := false,
  )


lazy val common = Project(id = "common", base = file("common"))
  .dependsOn()
  .settings(
      libraryDependencies ++= Seq(
          CommonDeps.scalaTest 
      )
  )

