package io.github.tjheslin1

import cats.Monad

import scala.language.higherKinds

trait Database[K, V] {

  def get[F[_]](key: K)(implicit m: Monad[F]): F[Option[V]]

  def all[F[_]](implicit m: Monad[F]): F[List[V]]

  def put[F[_]](key: K, value: V)(implicit m: Monad[F]): F[Unit]
}

class MemoryDatabase[F[_]] extends Database[String, Any] {

  private var cache = Map[String, Any]()

  def get[F[_]](key: String)(implicit m: Monad[F]): F[Option[Any]] = m.pure(cache.get(key))

  def all[F[_]](implicit m: Monad[F]): F[List[Any]] = m.pure(cache.values.toList)

  def put[F[_]](key: String, value: Any)(implicit m: Monad[F]): F[Unit] = m.pure(cache += (key -> value))
}