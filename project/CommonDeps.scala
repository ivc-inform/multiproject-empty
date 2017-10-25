package ru.simplesys.sbprocessing.sbtbuild

import sbt._

object PluginDeps {
    object versions {
        val sbtNativePackagerVersion = "1.2.4"
        val sbtResolverVersion = "0.9.0.1"
        val jrabelPluginVersion = "0.11.1"
    }

    val sbtNativePackager = addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % versions.sbtNativePackagerVersion)
    val sbtRevolver = addSbtPlugin("io.spray" % "sbt-revolver" % versions.sbtResolverVersion)
    val jrebelPlugin = addSbtPlugin("com.simplesys" % "jrebel-plugin" % versions.jrabelPluginVersion)
}

object CommonDeps {
    object versions {
        val scalaTestVersion = "3.0.3"
    }


    val scalaTest = "org.scalatest" %% "scalatest" % versions.scalaTestVersion
}
