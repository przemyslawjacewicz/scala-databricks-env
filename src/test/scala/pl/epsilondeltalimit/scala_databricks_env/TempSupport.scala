package pl.epsilondeltalimit.scala_databricks_env

import java.nio.file.{Files, Path}

trait TempSupport {
  def tempDir(): Path =
    Files.createTempDirectory(null)

  def tempDir(prefix: String = null): Path =
    Files.createTempDirectory(prefix)

  def tempFile(): Path =
    Files.createTempFile(null, null)

  def tempFile(prefix: String, suffix: String): Path =
    Files.createTempFile(prefix, suffix)

  def tempFile(dir: Path): Path =
    Files.createTempFile(dir, null, null)

  def tempFile(dir: Path, prefix: String, suffix: String): Path =
    Files.createTempFile(dir, prefix, suffix)
}
