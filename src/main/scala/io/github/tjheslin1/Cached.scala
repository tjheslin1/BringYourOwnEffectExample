package io.github.tjheslin1

import cats.Monad

import scala.language.higherKinds

abstract class Cached[F[_], T](implicit m: Monad[F]) {

  val db = new MemoryDatabase[F, T]()
}
