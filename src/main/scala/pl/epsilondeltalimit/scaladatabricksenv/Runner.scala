package pl.epsilondeltalimit.scaladatabricksenv

import io.delta.tables.DeltaTable
import org.apache.spark.sql.SparkSession
import pl.epsilondeltalimit.scaladatabricksenv.implicits._

// todo: usage scenarios
object Runner {

  val spark: SparkSession = ???

  def main(args: Array[String]): Unit = {

    dbutils.fs.ls("/tmp")

    dbutils.notebook.exit("ERROR")

    dbutils.widgets.removeAll

    display(spark.emptyDataFrame)

    DeltaTable.forPath("/path/to/source").cloneAtVersion(0, "/path/to/target", isShallow = false, replace = true)

  }

}
