package xyz.skycat.work.scala.cbee.config

import scala.xml.XML

/**
  * Created by SS on 2016/09/06.
  */
class ConfigParser {
  def generateConfig() = Config(XML.loadFile("src/main/resources/config.xml"))
}

object ConfigParser {
  def apply() = new ConfigParser
}
