package pl.epsilondeltalimit.scala_databricks_env.dbutils

package object widgets {
  def combobox(name: String, defaultValue: String, choices: Seq[String], label: String): Unit = ???

  def dropdown(name: String, defaultValue: String, choices: Seq[String], label: String): Unit = ???

  def get(name: String): String = ???

  def getAll: Map[String, String] = ???

  def getArgument(name: String, optional: String): String = ???

  def multiselect(name: String, defaultValue: String, choices: Seq[String], label: String): Unit = ???

  def remove(name: String): Unit = ???

  def removeAll(): Unit = ???

  def text(name: String, defaultValue: String, label: String = null): Unit = ???
}
