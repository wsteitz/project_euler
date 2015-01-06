
package euler

object Euler064 extends Euler {
    // http://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Continued_fraction_expansion

    def period(n: Int) = {

    val a_0 = math.sqrt(n).toInt

    def iterate(m: Int, d: Int, a: Int): Int = {
        if (a == 2 * a_0) 0
        else {
            val m_next = d * a - m
            val d_next = (n - m_next * m_next) / d
            if (d_next == 0) 0
            else {
                val a_next = (a_0 + m_next) / d_next
                1 + iterate(m_next, d_next, a_next)
            }
        }
    }
    iterate(0, 1, a_0)
    }

    def perfectSquare(n: Int) = {
      val m = math.sqrt(n).toInt
      m * m == n
    }

    def result = (2 to 10000).filter(!perfectSquare(_)).count(period(_) % 2 == 1)
}
