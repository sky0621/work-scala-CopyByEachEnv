package xyz.skycat.work.scala.cbee.config

import scala.xml.Elem

/**
  * Created by SS on 2016/09/06.
  */
case class Config private(configXml: Elem) {

  var copyList: List[Copy] = List()
  ((configXml \ "copy").theSeq).foreach {
    copyNode => copyList = copyList :+ Copy(copyNode)
  }
}
