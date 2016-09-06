package config

import scala.xml.NodeSeq

/**
  * Created by SS on 2016/09/06.
  */
class Convert private(convertNode: NodeSeq) {
  var from: String = (convertNode \ "from").text
  var to: String = (convertNode \ "to").text
}

object Convert {
  def apply(convertNode: NodeSeq) = new Convert(convertNode)
}
