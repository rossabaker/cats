package cats

import simulacrum.{typeclass}
import scala.annotation.implicitNotFound

@implicitNotFound("Could not find an instance of Selective for ${F}")
@typeclass trait Selective[F[_]] extends Applicative[F]
