package actor

import akka.actor.Actor
import akka.event.Logging
import config.Copy

/**
  * Created by SS on 2016/09/07.
  */
class CopyActor(copy: Copy) extends Actor {

  var log = Logging(context.system, this)

  override def receive: Receive = {
    case "start" => {
      log.info(copy.from.file)
    }
    case _ => {
      // Nothing
    }
  }
}
