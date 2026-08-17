package pl.epsilondeltalimit.scala_databricks_env.dbutils.fs

import org.scalatest.Inside.inside
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import pl.epsilondeltalimit.scala_databricks_env.TempSupport

import java.io.IOException
import java.nio.file.Files
import java.sql.Timestamp
import java.time.temporal.ChronoUnit.MINUTES
import java.time.{Duration, LocalDateTime}

class FsTest extends AnyFlatSpec with TempSupport with Matchers {
  val fs: Fs = new Fs

  val `1min`: Long = Duration.of(1, MINUTES).toMillis

  "cp" should "copy" in {
    pending
  }

  "head" should "print head of a file" in {
    pending
  }

  "ls" should "list contents in a location" in {
    val dir = tempDir()
    info(dir.toString)
    val file = tempFile(dir)
    info(file.toString)

    val contents = fs.ls(dir.toString)
    info(contents.mkString(","))
    info(contents.head.path)

    inside(contents.find(_.path == file.toString)) { case Some(fi) =>
      fi.name shouldBe file.getFileName.toString
      fi.size shouldBe 0
      fi.modificationTime shouldBe Timestamp.valueOf(LocalDateTime.now()).getTime +- `1min`
      fi.isDir() shouldBe false
      fi.isFile() shouldBe true
    }
  }

  it should "throw an exception if location does not exist" in {
    val thrown = the[Exception] thrownBy fs.ls("/non-existing-location")
    thrown.getMessage shouldBe "No such file or directory /non-existing-location"
  }

  "mkdirs" should "make dirs" in {
    pending
  }

  "mv" should "move" in {
    pending
  }

  "put" should "put file" in {
    pending
  }

  "rm" should "delete an existing file" in {
    val file = tempFile()
    info(file.toString)

    fs.rm(file.toString) shouldBe true
    Files.exists(file) shouldBe false
  }

  it should "delete an existing empty dir" in {
    val dir = tempDir()
    info(dir.toString)

    fs.rm(dir.toString) shouldBe true
    Files.exists(dir) shouldBe false
  }

  it should "delete an existing non-empty dir" in {
    val dir = tempDir()
    info(dir.toString)

    val file = tempFile(dir)
    info(file.toString)

    val thrown = the[IOException] thrownBy fs.rm(dir.toString)
    thrown.getMessage shouldBe s"Directory $dir is not empty"

    fs.rm(dir.toString, recurse = true) shouldBe true
    Files.exists(dir) shouldBe false
  }

  it should "not delete a non-existing file or dir" in {
    fs.rm("/non-existing-location") shouldBe false
    fs.rm("/non-existing-location", recurse = true) shouldBe false
  }

}
