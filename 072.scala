
package euler

import Primes.primeFactors


object Euler072 extends Euler {

    def count(n: Int): Long =
        primeFactors(n).distinct.foldLeft(n.toLong)((acc, c) => acc * (c - 1) / c)

    val result = (2 to 1000000).map(count).sum

}
