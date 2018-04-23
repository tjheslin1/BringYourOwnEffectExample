package unit

import io.github.tjheslin1.gymbookings.{Class, Classes}
import org.scalatest.{Matchers, WordSpec}

class ClassesSpec extends WordSpec with Matchers {

  "Classes" should {
    "populate available classes" in {
      val expectedClasses = List(Class("yoga"), Class("hiit"), Class("swimming"))

      val classes = Classes()
      classes.populate(expectedClasses)

      classes.availableClasses() shouldBe expectedClasses
    }
  }
}
