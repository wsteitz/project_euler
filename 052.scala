package euler


object Euler052 extends Euler {


    def sameDigits(a: Int, b: Int) =
        a.toString.sorted == b.toString.sorted

    val res = for {
                    x <- 1 to 1000000
                    if (1 to 6).forall(a => sameDigits(x, x * a))
                } yield x


    val result = res.head

}
