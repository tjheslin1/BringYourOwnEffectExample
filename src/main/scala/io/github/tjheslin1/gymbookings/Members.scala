package io.github.tjheslin1.gymbookings

import cats.Monad
import io.github.tjheslin1.Cached

import scala.language.higherKinds

case class Member(name: String)

case class Members[F[_]](implicit m: Monad[F]) extends Cached[F, Member] {

  def register(member: Member) = db.put(member.name, member)

  def allMembers() = db.all

  def memberByName(key: String) = db.get(key)

}
