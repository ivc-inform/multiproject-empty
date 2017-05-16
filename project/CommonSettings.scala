package ru.simplesys.sbprocessing.sbtbuild

import sbt.Setting

object CommonSettings {
    object settingValues {
        val baseVersion = "0.0"

        val scalaVersion = "2.12.2"
        val organization = "unknown"

        val scalacOptions = Seq(
            "-feature",
            "-language:higherKinds",
            "-language:implicitConversions",
            "-language:existentials",
            "-language:postfixOps",
            "-deprecation",
            "-unchecked")
    }

    val defaultSettings = {
        import sbt.Keys._
        Seq(
            scalacOptions := settingValues.scalacOptions,
            organization := settingValues.organization
        )
    }

    val defaultProjectSettings: Seq[Setting[_]] = {
        aether.AetherPlugin.autoImport.overridePublishSettings
    }

    val dockerGroupName = "mfmd"
}
