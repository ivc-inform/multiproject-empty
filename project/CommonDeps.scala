package ru.simplesys.sbprocessing.sbtbuild

import sbt._

object PluginDeps {
    val sbtNativePackagerVersion = "1.2.4"
    val sbtResolverVersion = "0.9.0.1"
    val jrabelPluginVersion = "0.11.1"

    val sbtNativePackager = addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % sbtNativePackagerVersion)
    val sbtRevolver = addSbtPlugin("io.spray" % "sbt-revolver" % sbtResolverVersion)
    val jrebelPlugin = addSbtPlugin("com.simplesys" % "jrebel-plugin" % jrabelPluginVersion)
}

object CommonDeps {
    val scalaTestVersion = "3.0.4"

    val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion % Test
}
