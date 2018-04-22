package io.github.tjheslin1.unit

import cats.Id
import io.github.tjheslin1.MemoryDatabase
import io.github.tjheslin1.gymbookings.Classes
import org.scalatest.{Matchers, WordSpec}

class ClassesSpec extends WordSpec with Matchers {

  "Classes" should {
    "populate available classes" in {
      val expectedClasses = List("yoga", "hiit", "swimming")

      val classes = Classes(new MemoryDatabase[Id]())
      classes.populate(expectedClasses)

      classes.availableClasses() shouldBe expectedClasses
    }
  }
}
