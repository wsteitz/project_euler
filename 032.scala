package euler

object Euler032 extends Euler {

    val pandigitalStr = "123456789"

    def isPandigital(n: Int) = {
        val s = n.toString
        s.distinct.size == s.size && !s.contains('0')
    }

    def isUnusual(a: Int, b: Int) =
        (a.toString + b.toString + (a * b).toString).sorted == pandigitalStr


    val ps = (1 to 4000).filter(isPandigital)

    val res = for {
        a <- ps
        b <- ps
        if a < 1000 & a < b && isUnusual(a, b)
      } yield a * b


    val result = res.distinct.sum

}
