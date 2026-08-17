package pl.epsilondeltalimit.scala_databricks_env

import io.delta.tables.DeltaTable
import org.apache.spark.sql.SparkSession
import pl.epsilondeltalimit.scala_databricks_env.dbutils.Dbutils

// todo: usage scenarios
object Runner {

  val spark: SparkSession = ???

  val dbutils: Dbutils = new Dbutils

  def main(args: Array[String]): Unit = {

    dbutils.fs.ls("/tmp")

    dbutils.notebook.exit("ERROR")

    dbutils.widgets.removeAll()

    display(spark.emptyDataFrame)

    DeltaTable.forPath("/path/to/source").cloneAtVersion(0, "/path/to/target", isShallow = false, replace = true)

  }

}
