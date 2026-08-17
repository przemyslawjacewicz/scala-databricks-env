package pl.epsilondeltalimit

import org.apache.spark.sql.Dataset

package object scala_databricks_env {
  def display(ds: Dataset[_]): Unit = ???

  def display[A](s: Seq[A]): Unit = ???
}
