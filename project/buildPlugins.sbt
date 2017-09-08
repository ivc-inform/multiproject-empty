//import com.typesafe.sbt.GitVersioning
//import com.typesafe.sbt.SbtGit.git
import ru.simplesys.sbprocessing.sbtbuild.{CommonSettings, PluginDeps}
import sbt._

lazy val root = Project(id = "buildPlugins", base = file(".")).//enablePlugins(GitVersioning).
  settings(inThisBuild(CommonSettings.defaultSettings ++ Seq(
      //git.baseVersion := CommonSettings.settingValues.baseVersion
  ))).
  settings(
      PluginDeps.sbtNativePackager
  )
