package pl.epsilondeltalimit.scala_databricks_env.dbutils.fs

import java.nio.file.{Files, Path}

class FileInfo(filepath: Path) {

  // contains `dbfs:` prefix
  def path: String =
    filepath.toString

  // last part of path
  def name: String =
    filepath.getFileName.toString

  // size in bytes
  def size: Long =
    Files.size(filepath)

  // modificationTime in ms from epoch
  def modificationTime: Long =
    Files.getLastModifiedTime(filepath).toMillis

  def isDir(): Boolean =
    Files.isDirectory(filepath)

  def isFile(): Boolean =
    Files.isRegularFile(filepath)

  override def toString: String = s"FileInfo(path=$path, name=$name, size=$size, modificationTime=$modificationTime)"
}
