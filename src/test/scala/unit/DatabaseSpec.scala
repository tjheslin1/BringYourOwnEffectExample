package unit

import cats.Id
import io.circe.Json
import io.circe.parser._
import io.github.tjheslin1.MemoryDatabase
import org.scalatest.{EitherValues, Matchers, OptionValues, WordSpec}

import scala.util.Random

class DatabaseSpec extends WordSpec
  with Matchers
  with EitherValues
  with OptionValues {

  "MemoryDatabase" should {
    "retrieve cached element by key" in {
      val message = "testMessage"

      val db = new MemoryDatabase[Id, String]()
      db.put[Id]("xxx", message)

      db.get("xxx").value shouldBe message
    }

    "retrieve all cached elements" in {
      val messages = List("message1", "message2", "message3")
      val db = new MemoryDatabase[Id, String]()
      messages.foreach(db.put[Id](Random.nextInt().toString, _))

      db.all shouldBe messages
    }
  }
}
