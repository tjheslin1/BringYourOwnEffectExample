package io.github.tjheslin1.gymbookings

import io.github.tjheslin1.MemoryDatabase

import scala.language.higherKinds

case class Classes[F[_]](classesDb: MemoryDatabase[F]) {

  def populate(expectedClasses: List[String]) = expectedClasses.foreach(classesDb.put(_, ???))

  def availableClasses() = classesDb.all

}
