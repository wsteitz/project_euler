package euler

// solution is to reformulate and simplify. since we are only interested in the
// max mod a^2, we can forget about huge parts of the equation

object Euler120 extends Euler {
    def maxr(a: Int) = 2 * a * (if (a % 2 == 0) a / 2 - 1 else a / 2)

    val result = (3 to 1000).map(maxr).sum

}
