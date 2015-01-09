
package euler


object Euler045 extends Euler{

    def h(n: Long) = n * (2 * n - 1)
    def isPentagonal(n: Long) = ((math.sqrt(1 + 24 * n) + 1.0) / 6.0) % 1 == 0

    val result = (286 to 100000).map(_.toLong)
                                .find(n => isPentagonal(h(n))).map(h)
                                .getOrElse("")

}
