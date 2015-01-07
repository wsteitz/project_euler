package euler

object Euler001 extends Euler {

    val result = (0 until 1000).filter(n => n % 3 == 0 || n % 5 == 0).sum
}
