trait Cache[K, V] {

  def get[F[_]](key: K): F[Option[V]]

  def put[F[_]](key: K, value: V): F[Unit]
}
