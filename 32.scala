package euler

object Euler032 extends Euler {


    def isPandigital(n: String) = {
        n.size ==9 && n.distinct.size == n.size && !n.contains('0')
    }

    val res = for {
                a <- 1 until 10000
                b <- a until 10000
                if isPandigital(a.toString + b.toString + (a * b).toString)
            } yield a * b


    val result = res.distinct.sum

}
