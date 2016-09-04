import org.json4s._
import org.json4s.jackson.JsonMethods._

import scalax.file.Path

/**
  * Created by SS on 2016/09/05.
  */
object Main extends App {

  // JSON設定ファイルを読み込むロジックを実装（まずファイルリソースとして）
  // JSON文字列をパースするロジックを実装
  // コピー設定に応じたコピーロジックを実装
  // コピーの開始（終了？）をメッセージとしてやりとりするAkkaのアクターロジックを実装

  val jsonPath = Path("src/main/resources/config.json")
  var jsonString: String = ""
  jsonPath.lines().foreach {
    line => jsonString = jsonString + line
  }
  //  println(jsonString)

  val configList = parse(jsonString).asInstanceOf[JObject].values.get("Configs").getOrElse(List)
  println(configList)


}
