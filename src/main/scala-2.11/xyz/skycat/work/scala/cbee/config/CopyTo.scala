package xyz.skycat.work.scala.cbee.config

import scala.xml.NodeSeq

/**
  * Created by SS on 2016/09/06.
  */
case class CopyTo private(toNode: NodeSeq) {

  val dir: String = (toNode \ "dir").text
  val file: String = (toNode \ "file").text

  var convertList: List[Convert] = List()
  (toNode \ "convert").foreach {
    to => convertList = convertList :+ Convert(to)
  }
}