package pl.epsilondeltalimit.scaladatabricksenv.dbutils

package object notebook {
  def exit(value: String): Unit = ???

  def run(path: String, timeoutSeconds: Int, arguments: Map[String, String]): String = ???

  def getContext(): CommandContext = ???

  def setContext(ctx: CommandContext): Unit = ???
}
