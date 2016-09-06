package config

import scala.xml.Elem

/**
  * Created by SS on 2016/09/06.
  */
class Config private(configXml: Elem) {

  private var copyList: List[Copy] = List()

  ((configXml \ "copy").theSeq).foreach {
    copy => {
      var copyObj: Copy = new Copy()
      this.copyList = this.copyList :+ copyObj
      (copy \ "from").foreach {
        from => {
          var fromObj: CopyFrom = new CopyFrom()
          copyObj.from = fromObj

        }
      }
      (copy \ "to").foreach {
        to => {
          var toObj: CopyTo = new CopyTo()
          copyObj.toList = copyObj.toList :+ toObj
        }
      }
    }
  }
}

object Config {
  def apply(configXml: Elem) = new Config(configXml)
}
