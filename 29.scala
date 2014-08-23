package euler

object Euler029 extends Euler{

    val ns = 2 to 100

    val result = (for {
                    a <- ns
                    b <- ns
                } yield BigInt(a).pow(b)).distinct.sorted.size
}
