package xyz.skycat.work.scala.cbee.config

import scala.xml.NodeSeq

/**
  * Created by SS on 2016/09/06.
  */
case class Convert private(convertNode: NodeSeq) {

  val from: String = (convertNode \ "from").text
  val to: String = (convertNode \ "to").text

  def replaceAll(target: String): String = target.replaceAll(from, to)
}
