package config

import scala.xml.NodeSeq

/**
  * Created by SS on 2016/09/06.
  */
class Copy private(copyNode: NodeSeq) {

  val from = CopyFrom(copyNode \ "from")

  var toList: List[CopyTo] = List()
  (copyNode \ "to").foreach {
    to => toList = toList :+ CopyTo(to)
  }
}

object Copy {
  def apply(copyNode: NodeSeq) = new Copy(copyNode)
}
