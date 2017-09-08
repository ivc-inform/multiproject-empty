package ru.simplesys.sbprocessing.sbtbuild

import sbt.Setting

object CommonSettings {
    object settingValues {
        val scalaVersion = "2.12.3"
        val organization = "unknown"
        //val baseVersion = "0.0.0.0"

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
}
