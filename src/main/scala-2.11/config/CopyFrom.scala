package config

import scala.xml.NodeSeq

/**
  * Created by SS on 2016/09/06.
  */
class CopyFrom private(fromNode: NodeSeq) {
  val dir = (fromNode \ "dir").text
  val file = (fromNode \ "file").text
}

object CopyFrom {
  def apply(fromNode: NodeSeq) = new CopyFrom(fromNode)
}
