import chrome._
import chrome.permissions.Permission
import chrome.permissions.Permission.{API, Host}
import net.lullabyte.{Chrome, ChromeSbtPlugin}

lazy val extension = project.in(file("."))
  .enablePlugins(ChromeSbtPlugin)
  .settings(
    name := "Example Extension",
    version := "0.0.1",
    scalaVersion := "2.12.2",
    scalacOptions ++= Seq(
      "-language:implicitConversions",
      "-language:existentials",
      "-Xlint",
      "-deprecation",
      "-Xfatal-warnings",
      "-feature"
    ),
    scalaJSUseMainModuleInitializer := true,
    scalaJSUseMainModuleInitializer in Test := false,
    relativeSourceMaps := true,
    skip in packageJSDependencies := false,
    libraryDependencies ++= Seq("net.lullabyte" %%% "scala-js-chrome" % "0.5.0"),
    chromeManifest := new ExtensionManifest {
      val background = Background(
        scripts = Chrome.defaultScripts
      )
      val name = Keys.name.value
      val version = Keys.version.value
      override val icons = Chrome.icons(
        "icons",
        "icon.png",
        Set(256)
      )
      override val permissions = Set[Permission](
        API.Tabs
      )
    }
  )