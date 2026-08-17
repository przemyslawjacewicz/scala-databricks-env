package pl.epsilondeltalimit.scala_databricks_env

import io.delta.tables.DeltaTable

package object implicits {
  implicit class DeltaTableOps(t: DeltaTable) {
    def clone(targetPath: String, isShallow: Boolean, replace: Boolean): Unit =
      ???

    def cloneAtVersion(version: Long, targetPath: String, isShallow: Boolean, replace: Boolean): Unit =
      ???
  }

}
