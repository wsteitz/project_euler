package euler

object Euler038 extends Euler {


    def isPandigital(n: String) = {
        n.size == 9 && n.distinct.size == n.size && !n.contains('0')
    }

    def concatenatedProduct(x: Int, n: Int) =
        (1 to n).map(_ * x).map(_.toString).mkString


    val result = (for {
                x <- 1 to 10000
                n <- 2 to 5

                value = concatenatedProduct(x, n)
                if isPandigital(value)
            } yield value).max

}
