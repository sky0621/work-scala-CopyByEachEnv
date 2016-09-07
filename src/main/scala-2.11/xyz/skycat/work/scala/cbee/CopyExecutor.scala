package xyz.skycat.work.scala.cbee

import xyz.skycat.work.scala.cbee.config.Copy

import scalax.file.Path

/**
  * Created by SS on 2016/09/07.
  */
case class CopyExecutor private(copy: Copy) {

  var lastModified: Long = _
  val fromPath: Path = copy.from.toAbsolutePath

  def modifiedCopy(): Unit = {
    if (lastModified == copy.from.lastModified) return
    println("[lastModified:" + lastModified + "][copy.from.lastModified:" + copy.from.lastModified + "]")

    copy.toList.foreach {
      to => {
        // [COPY] from -> to
        copy.from.toAbsolutePath.copyTo(to.toAbsolutePath, replaceExisting = true)

        // [MAKE REPLACED TMP FILE]
        var toTmpPath: Path = to.toTmpAbsolutePath
        to.toAbsolutePath.lines().foreach {
          line => {
            var tmpLine = line
            to.convertList.foreach(convert => tmpLine = convert.replaceAll(line))
            toTmpPath.append(tmpLine + "\n")
          }
        }

        // [TMP FILE -> TO FILE]
        toTmpPath.copyTo(to.toAbsolutePath, replaceExisting = true)
        toTmpPath.delete(true)
      }
    }

    lastModified = copy.from.lastModified
  }
}
