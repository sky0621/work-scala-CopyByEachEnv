package xyz.skycat.work.scala.cbee

import akka.actor.Actor
import akka.event.Logging
import xyz.skycat.work.scala.cbee.config.Copy

import scalax.file.Path

/**
  * Created by SS on 2016/09/07.
  */
class CopyActor(copy: Copy) extends Actor {

  var log = Logging(context.system, this)

  override def receive: Receive = {
    case "start" => {
      var fromPath = Path(copy.from.dir + copy.from.file).toAbsolute
      println(fromPath)
      copy.toList.foreach {
        to => {
          val toPath = Path(to.dir + to.file).toAbsolute
          fromPath.copyTo(toPath, replaceExisting = true)
        }
      }
    }
    case _ => {
      // Nothing
    }
  }
}
