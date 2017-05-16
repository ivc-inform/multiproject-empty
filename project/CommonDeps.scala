package ru.simplesys.sbprocessing.sbtbuild

import sbt.Keys.scalaVersion
import sbt.{Def, _}

object PluginDeps {
    object versions {
        val sbtNativePackagerVersion = "1.2.0-M8"
    }

    val sbtNativePackager = addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % versions.sbtNativePackagerVersion)
}

object CommonDeps {
    object versions {
        
        val akkaVersion = "2.4.18"
        val akkaHttpVersion = "10.0.6"
        
        val scalaTestVersion = "3.0.1"
        val loggingVersion = "3.5.0"
        val configTypesafeVersion = "1.3.1"
    }
    
    val akkaActor = Def.setting("com.typesafe.akka" %% "akka-actor" % versions.akkaVersion)
    val akkaSLF4J = Def.setting("com.typesafe.akka" %% "akka-slf4j" % versions.akkaVersion)
    val akkaPersistence = Def.setting("com.typesafe.akka" %% "akka-persistence" % versions.akkaVersion)
    val akkaTestKit = Def.setting("com.typesafe.akka" %% "akka-testkit" % versions.akkaVersion)
    val akkaQuery = Def.setting("com.typesafe.akka" %% "akka-persistence-query-experimental" % versions.akkaVersion)
    val akkaStream = Def.setting("com.typesafe.akka" %% "akka-stream" % versions.akkaVersion)
    val akkaStreamTestKid = Def.setting("com.typesafe.akka" %% "akka-stream-testkit" % versions.akkaVersion)

    val akkaHTTPCore = Def.setting("com.typesafe.akka" %% "akka-http-core" % versions.akkaHttpVersion)
    val akkaHttpXml = Def.setting("com.typesafe.akka" %% "akka-http-xml" % versions.akkaHttpVersion)
    val akkaHttp = Def.setting("com.typesafe.akka" %% "akka-http" % versions.akkaHttpVersion)
    val akkaHttpTestKid = Def.setting("com.typesafe.akka" %% "akka-http-testkit" % versions.akkaHttpVersion)

    val logging = Def.setting("com.typesafe.scala-logging" %% "scala-logging" % versions.loggingVersion)
    val configTypesafe = Def.setting("com.typesafe" % "config" % versions.configTypesafeVersion)

    val scalaTest = Def.setting("org.scalatest" %% "scalatest" % versions.scalaTestVersion)
}

object DepsHelper {
    def moduleId(scalaVer: String,
                 moduleId_2_12: Option[ModuleID],
                 moduleId_2_10: Option[ModuleID]): Option[ModuleID] =
        CrossVersion.partialVersion(scalaVer) match {
            case Some((2, scalaMajor)) if scalaMajor >= 12 => moduleId_2_12
            case _ => moduleId_2_10
        }
}
