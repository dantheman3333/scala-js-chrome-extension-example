import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.document
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

object Main extends JSApp {
  @JSExport
  override def main(): Unit = {
    println("In content Script!")
    val NoArgs =
      ScalaComponent.builder[Unit]("No args")
        .renderStatic(<.div("Hello Content!"))
        .build

    NoArgs().renderIntoDOM(document.body)
  }

}
