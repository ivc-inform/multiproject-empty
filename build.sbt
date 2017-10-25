import com.simplesys.jrebel.JRebelPlugin.jrebel
import ru.simplesys.sbprocessing.sbtbuild.{CommonDeps, CommonSettings}
import sbt.{Credentials, Path}

name := "multiproject-empty"

lazy val root = (project in file("."))
  //.enablePlugins(GitVersioning)
  .aggregate(common)
  .settings(
      inThisBuild(Seq(
          credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
      ) ++ CommonSettings.defaultSettings),
      scalaVersion := CommonSettings.settingValues.scalaVersion,
      publishTo := {
          val corporateRepo = "http://toucan.simplesys.lan/"
          if (isSnapshot.value)
              Some("snapshots" at corporateRepo + "artifactory/libs-snapshot-local")
          else
              Some("releases" at corporateRepo + "artifactory/libs-release-local")
      },
      publishArtifact in(Compile, packageBin) := false,
      publishArtifact in(Compile, packageDoc) := false,
      publishArtifact in(Compile, packageSrc) := false
  )


lazy val common = Project(id = "common", base = file("common"))
  .dependsOn()
  .settings(
      libraryDependencies ++= Seq(
          CommonDeps.scalaTest
      ),
      javaOptions ++= Seq(
          "-javaagent:../jrebel/jrebel.jar",
          "-noverify",
          "-XX:+UseConcMarkSweepGC",
          "-XX:+CMSClassUnloadingEnabled"
      ),
      JRebelPlugin.jrebelSettings,
      jrebel.enabled := true
  )

