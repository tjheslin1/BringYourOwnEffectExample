package io.github.tjheslin1

import cats.Monad

import scala.language.higherKinds

trait Database[K, V] {

  def get[F[_]](key: K)(implicit m: Monad[F]): F[Option[V]]

  def all[F[_]](implicit m: Monad[F]): F[List[V]]

  def put[F[_]](key: K, value: V)(implicit m: Monad[F]): F[Unit]
}

class MemoryDatabase[F[_], T] extends Database[String, T] {

  private var cache = Map[String, T]()

  def get[F[_]](key: String)(implicit m: Monad[F]): F[Option[T]] = m.pure(cache.get(key))

  def all[F[_]](implicit m: Monad[F]): F[List[T]] = m.pure(cache.values.toList)

  def put[F[_]](key: String, value: T)(implicit m: Monad[F]): F[Unit] = m.pure(cache += (key -> value))
}