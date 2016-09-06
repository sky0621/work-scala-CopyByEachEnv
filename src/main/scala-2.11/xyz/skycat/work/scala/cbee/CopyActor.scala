package xyz.skycat.work.scala.cbee

import akka.actor.Actor
import akka.event.Logging

/**
  * Created by SS on 2016/09/07.
  */
class CopyActor(copyExecutor: CopyExecutor) extends Actor {

  var log = Logging(context.system, this)

  override def receive: Receive = {
    case "start" => {
      copyExecutor.modifiedCopy()
    }
    case _ => {
      // Nothing
    }
  }
}
