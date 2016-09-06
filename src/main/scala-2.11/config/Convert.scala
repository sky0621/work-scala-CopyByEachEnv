package config

import scala.xml.NodeSeq

/**
  * Created by SS on 2016/09/06.
  */
case class Convert private(convertNode: NodeSeq) {

  val from: String = (convertNode \ "from").text
  val to: String = (convertNode \ "to").text
}
