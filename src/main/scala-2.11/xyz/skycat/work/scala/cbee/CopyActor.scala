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
      val copyExecutor = CopyExecutor(Path(copy.from.dir + copy.from.file).toAbsolute)
      copy.toList.foreach(to => copyExecutor.modifiedCopy(Path(to.dir + to.file).toAbsolute))
    }
    case _ => {
      // Nothing
    }
  }
}
