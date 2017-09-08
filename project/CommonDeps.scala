package ru.simplesys.sbprocessing.sbtbuild

import sbt.{Def, _}

object PluginDeps {
    object versions {
        val sbtNativePackagerVersion = "1.2.4"
    }

    val sbtNativePackager = addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % versions.sbtNativePackagerVersion)
}

object CommonDeps {
    object versions {
        val scalaTestVersion = "3.0.3"
    }


    val scalaTest = "org.scalatest" %% "scalatest" % versions.scalaTestVersion
}
