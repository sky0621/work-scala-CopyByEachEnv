import config.{Config, ConfigParser}

/**
  * Created by SS on 2016/09/05.
  */
object Main extends App {

  // コピー設定に応じたコピーロジックを実装
  // コピーの開始（終了？）をメッセージとしてやりとりするAkkaのアクターロジックを実装

  val config: Config = ConfigParser().generateConfig()
  println(config)

}
