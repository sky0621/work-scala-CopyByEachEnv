package xyz.skycat.work.scala.cbee.config

import scala.xml.XML

/**
  * Created by SS on 2016/09/06.
  */
case class ConfigParser private(path: String) {
  def generateConfig() = {
    if(path == null) {
      Config(XML.loadFile("src/main/resources/config.xml"))
    } else {
      Config(XML.loadFile(path))
    }
  }
}
