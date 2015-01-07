package euler

object Euler024 extends Euler {
    val n = 1000000
    val result = (0 to 9).permutations.drop(n - 1).next.mkString

}
