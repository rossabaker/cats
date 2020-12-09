package cats

import simulacrum.{typeclass}
import scala.annotation.implicitNotFound

@implicitNotFound("Could not find an instance of Select for ${F}")
@typeclass trait Select[F[_]] extends Apply[F] {
  def select[A, B](fab: F[Either[A, B]])(ff: F[A => B]): F[B] =
    map2(fab, ff) {
      case (Left(a), f)  => f(a)
      case (Right(b), f) => b
    }
}
