package xyz.skycat.work.scala.cbee

import akka.actor.{ActorRef, ActorSystem, Props}
import xyz.skycat.work.scala.cbee.config.{Config, ConfigParser}

/**
  * Created by SS on 2016/09/05.
  */
object Main extends App {

  val config: Config = ConfigParser(args(0)).generateConfig
  val system = ActorSystem("copySystem")

  var actorList = List[ActorRef]()
  config.copyList.foreach(copy => actorList = actorList :+ system.actorOf(Props(classOf[CopyActor], CopyExecutor(copy)), name = "copyActor" + actorList.size))

  while (true) {
    actorList.foreach { actor => actor ! "start" }
    Thread.sleep(5000)
  }
}
