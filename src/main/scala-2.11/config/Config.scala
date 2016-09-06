package config

import scala.xml.Elem

/**
  * Created by SS on 2016/09/06.
  */
class Config private(configXml: Elem) {

  var copyList: List[Copy] = List()
  ((configXml \ "copy").theSeq).foreach {
    copyNode => copyList = copyList :+ Copy(copyNode)
  }
}

object Config {
  def apply(configXml: Elem) = new Config(configXml)
}
