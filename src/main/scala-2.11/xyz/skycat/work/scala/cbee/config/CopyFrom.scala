package xyz.skycat.work.scala.cbee.config

import scala.xml.NodeSeq
import scalax.file.Path

/**
  * Created by SS on 2016/09/06.
  */
case class CopyFrom private(fromNode: NodeSeq) {

  val dir = (fromNode \ "dir").text
  val file = (fromNode \ "file").text

  def toAbsolutePath(): Path = Path(dir + file).toAbsolute

  def lastModified(): Long = toAbsolutePath().lastModified
}
