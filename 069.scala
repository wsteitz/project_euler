
package euler

import Primes.primeFactors


object Euler069 extends Euler {

    def totient(n: Int): Long =
        primeFactors(n).distinct.foldLeft(n.toLong)((acc, c) => acc * (c - 1) / c)

    val result = (2 to 1000000).map(n => (n, n.toDouble / totient(n)))
                               .maxBy(_._2)._1

}
