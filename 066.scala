
package euler

// http://en.wikipedia.org/wiki/Pell%27s_equation#Fundamental_solution_via_continued_fractions

object Euler066 extends Euler {

    def continuedFraction(n: Int) = {
        val a_0 = math.sqrt(n).toInt

        def iterate(m: Int, d: Int, a: Int): Stream[Int] = {
            val m_next = d * a - m
            val d_next = (n - m_next * m_next) / d
            val a_next = (a_0 + m_next) / d_next
            a_next #:: iterate(m_next, d_next, a_next)
        }
        a_0 #::iterate(0, 1, a_0)
    }

    def perfectSquare(n: Int) = {
      val m = math.sqrt(n).toInt
      m * m == n
    }

    def fractions(n: Int) = {
        val as = continuedFraction(n)
        Stream.from(1).map(i => as.take(i).map(BigFraction(_))
                      .reduceRight((next, current) => current.reciprocal + next))
    }

    def isSolution(f: BigFraction, d: Int) = f.n * f.n - d * f.d * f.d == 1

    def result = (2 to 1000).filterNot(perfectSquare)
                            .map(d => (d, fractions(d).find(isSolution(_, d)).get.n))
                            .maxBy(_._2)._1
}
