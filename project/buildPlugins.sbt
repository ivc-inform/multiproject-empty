import sbt._


//lazy val mergeJS = uri("../../sbt-plugins/merge-js")

lazy val root = Project(id = "buildPlugins", base = file(".")).dependsOn(
    /*RootProject(sbtNativePackager), */
    /*RootProject(mergeJS)*/
)

  .settings(sbt.inThisBuild(CommonSettings.defaultSettings))
  .settings(
      classpathTypes += "maven-plugin",
      PluginDeps.sbtCoffeeScript,
      PluginDeps.mergeJS,
      PluginDeps.xsbtWeb,
      PluginDeps.sbtNativePackager,
      PluginDeps.jrebelPlugin,
      PluginDeps.crossproject,
      PluginDeps.sbtCrossproject
  )
