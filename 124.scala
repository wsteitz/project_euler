
package euler

import Primes.primeFactors


object Euler124 extends Euler {

    def radical(n: Int) = primeFactors(n).distinct.foldLeft(1)(_ * _)

    val result = (1 to 100000).map(n => (radical(n), n))
                              .sorted.take(10000).reverse.head._2

}

