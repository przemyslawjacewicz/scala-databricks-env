package pl.epsilondeltalimit.scaladatabricksenv.dbutils

import java.io.IOException
import java.nio.file._
import java.nio.file.attribute.BasicFileAttributes
import scala.collection.JavaConverters.asScalaIteratorConverter
import scala.util.{Failure, Success, Try}

package object fs {
  def cp(from: String, to: String, recurse: Boolean = false): Boolean = ???

  def head(file: String, maxBytes: Int = 65536): String = ???

  def ls(dir: String): Seq[FileInfo] = {
    println("dbutils.fs.ls")

    Try(Files.list(Paths.get(dir)).iterator().asScala.toArray.map(FileInfo.apply))
      .transform(
        s => Success(s),
        {
          case _: NoSuchFileException => Failure(new Exception(s"No such file or directory $dir"))
          case e => Failure(e)
        }
      )
      .get
  }


  def mkdirs(dir: String): Boolean = ???

  def mv(from: String, to: String, recurse: Boolean = false): Boolean = ???

  def put(file: String, content: String, overwrite: Boolean = false): Boolean = ???

  def rm(dir: String, recurse: Boolean = false): Boolean = {
    println("dbutils.fs.rm")

    def deleteRecursively(root: Path): Unit =
      if (root != null && Files.exists(root)) {
        Files.walkFileTree(
          root,
          new SimpleFileVisitor[Path] {

            override def visitFile(file: Path, attrs: BasicFileAttributes): FileVisitResult = {
              Files.deleteIfExists(file)
              FileVisitResult.CONTINUE
            }

            override def postVisitDirectory(dir: Path, exc: IOException): FileVisitResult = {
              if (exc != null) throw exc
              Files.deleteIfExists(dir)
              FileVisitResult.CONTINUE
            }
          }
        )
      }

    val dirPath = Paths.get(dir)

    if (Files.exists(dirPath)) {
      if (Files.isRegularFile(dirPath) || Files.list(dirPath).toArray.isEmpty || recurse) {
        Try(deleteRecursively(Paths.get(dir))).transform(_ => Success(true), _ => Success(false)).get
      } else {
        throw new IOException(s"Directory $dir is not empty")
      }
    } else {
      false
    }
  }

}
