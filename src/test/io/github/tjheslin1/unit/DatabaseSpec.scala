package io.github.tjheslin1.unit

import cats.Id
import io.circe.Json
import io.github.tjheslin1.MemoryDatabase
import org.scalatest.{EitherValues, Matchers, OptionValues, WordSpec}
import io.circe.parser._

import scala.util.Random

class DatabaseSpec extends WordSpec
  with Matchers
  with EitherValues
  with OptionValues {

  "MemoryDatabase" should {
    "retrieve cached element by key" in {
      val json = parse("""{ "test": "value" }""")

      val db = new MemoryDatabase()
      db.put[Id]("test", json.getOrElse(Json.Null))

      db.get("test").value shouldBe json.right.value
    }

    "retrieve all cached elements" in {
      val json = List(parse("""{ "test": "value" }"""),
        parse("""{ "test2": "value2" }"""),
        parse("""{ "test3": "value3" }"""))

      val db = new MemoryDatabase()
      json.foreach(js => db.put[Id](Random.nextInt().toString, js.getOrElse(Json.Null)))

      db.all shouldBe json.map(_.right.value)
    }
  }
}
