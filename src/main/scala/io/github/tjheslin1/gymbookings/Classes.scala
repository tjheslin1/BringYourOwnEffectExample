package io.github.tjheslin1.gymbookings

import cats.Monad
import io.github.tjheslin1.Cached

import scala.language.higherKinds
import scala.util.Random

case class Class(name: String)

case class Classes[F[_]](implicit m: Monad[F]) extends Cached[F, Class] {

  def populate(expectedClasses: List[Class]) = m.pure(expectedClasses.foreach(db.put(Random.nextInt.toString, _)))

  def availableClasses() = db.all
}

object Classes {

  val defaultClasses = List(Class("yoga"), Class("hiit"), Class("swimming"), Class("grid"))
}