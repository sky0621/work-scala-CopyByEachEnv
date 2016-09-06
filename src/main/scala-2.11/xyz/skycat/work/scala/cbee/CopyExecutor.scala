package xyz.skycat.work.scala.cbee

import scalax.file.Path

/**
  * Created by SS on 2016/09/07.
  */
case class CopyExecutor private(from: Path) {

  def modifiedCopy(to: Path): Unit = {
    from.copyTo(to, replaceExisting = true)
  }
}
