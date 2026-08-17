package pl.epsilondeltalimit.scala_databricks_env.dbutils

import pl.epsilondeltalimit.scala_databricks_env.dbutils.fs.Fs
import pl.epsilondeltalimit.scala_databricks_env.dbutils.notebook.Notebook
import pl.epsilondeltalimit.scala_databricks_env.dbutils.widgets.Widgets

class Dbutils(widgetsAsMap: Map[String, String] = Map.empty) {
  val fs: Fs             = new Fs
  val notebook: Notebook = new Notebook
  val widgets: Widgets   = new Widgets(widgetsAsMap)
}
