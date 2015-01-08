package euler

object Euler044 extends Euler {

    def pentagonal(n: Int) = n * (3 * n - 1) / 2

    val ps = (1 to 3000).map(pentagonal).toSet

    val result = (for {
        a <- ps
        b <- ps
        if a < b } yield (a, b))
        .filter{case (a, b) => ps.contains(a + b) && ps.contains(math.abs(a - b))}
        .map{case (a, b) => math.abs(a - b)}.head

}
