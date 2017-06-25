enablePlugins(ScalaJSPlugin)

name := "Popup Window Example"
scalaVersion := "2.12.2"

version := "0.0.1"

libraryDependencies += "com.github.japgolly.scalajs-react" %%% "core" % "1.0.1"

jsDependencies ++= Seq(

  "org.webjars.bower" % "react" % "15.5.4"
    /        "react-with-addons.js"
    minified "react-with-addons.min.js"
    commonJSName "React",

  "org.webjars.bower" % "react" % "15.5.4"
    /         "react-dom.js"
    minified  "react-dom.min.js"
    dependsOn "react-with-addons.js"
    commonJSName "ReactDOM",

  "org.webjars.bower" % "react" % "15.5.4"
    /         "react-dom-server.js"
    minified  "react-dom-server.min.js"
    dependsOn "react-dom.js"
    commonJSName "ReactDOMServer")


scalaJSUseMainModuleInitializer := true

