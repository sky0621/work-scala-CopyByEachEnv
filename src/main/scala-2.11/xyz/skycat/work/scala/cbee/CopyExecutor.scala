package xyz.skycat.work.scala.cbee

import xyz.skycat.work.scala.cbee.config.Copy

import scalax.file.Path

/**
  * Created by SS on 2016/09/07.
  */
case class CopyExecutor private(copy: Copy) {

  var from: Path = Path(copy.from.dir + copy.from.file).toAbsolute
  var lastModified: Long = from.lastModified

  def modifiedCopy(): Unit = {
    val nowFrom: Path = Path(copy.from.dir + copy.from.file).toAbsolute
//    if (nowFrom.lastModified == lastModified) return
//    println(lastModified)
    copy.toList.foreach {
      to => {
        val toPath = Path(to.dir + to.file).toAbsolute
        val toTmpPath = Path(to.dir + to.file + ".tmp").toAbsolute
        from.copyTo(toPath, replaceExisting = true)
        toPath.lines().foreach{
          line => {
            var tmpLine = line
            to.convertList.foreach {
              convert => {
                // FIXME 改行されてない。複数ファイル分、入ってしまう？
                tmpLine = tmpLine.replaceAll(convert.from, convert.to)
              }
            }
            toTmpPath.append(tmpLine)
          }
        }
      }
    }
  }
}
