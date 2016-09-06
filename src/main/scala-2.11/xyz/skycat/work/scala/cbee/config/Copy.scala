package xyz.skycat.work.scala.cbee.config

import scala.xml.NodeSeq

/**
  * Created by SS on 2016/09/06.
  */
case class Copy private(copyNode: NodeSeq) {

  val from = CopyFrom(copyNode \ "from")

  var toList: List[CopyTo] = List()
  (copyNode \ "to").foreach {
    to => toList = toList :+ CopyTo(to)
  }
}
