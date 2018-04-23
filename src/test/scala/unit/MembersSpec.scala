package unit

import cats.Id
import io.github.tjheslin1.gymbookings.{Class, Classes, Member, Members}
import org.scalatest.{Matchers, WordSpec}

class MembersSpec extends WordSpec with Matchers {

  "Members" should {
    "register new members" in {
      val expectedMembers = List(Member("tom"), Member("fiona"), Member("jim"))

      val members = Members[Id, Member]()
      expectedMembers.foreach(x => members.register(x))

      members.allMembers() shouldBe expectedMembers
    }

    "retrieve member by name" in {
      val expectedMembers = List(Member("tom"), Member("fiona"), Member("jim"))

      val members = Members[Id, Member]()
      expectedMembers.foreach(x => members.register(x))

      members.memberByName("fiona").get shouldBe Member("fiona")
    }
  }
}
