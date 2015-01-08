package euler

object Euler044 extends Euler {

    def pentagonal(n: Int) = n * (3 * n - 1) / 2

    val ps = (1 to 10000).map(pentagonal).toSet

    println("got ps")

    val result = (for {
        a <- ps
        b <- ps
        if a < b } yield (a, b))
        .find(t =>
           ps.contains(t._1 + t._2) &&
           ps.contains(t._2 - t._1)
          )



}
