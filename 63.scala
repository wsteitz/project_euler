package euler

object Euler063 extends Euler {
    val result = (for {
        i <- 1 to 100
        p <- 1 to 100
        n = BigInt(i).pow(p).toString
        if n.size == p } yield (i, p, n)).size

}
