package euler

import Primes.primesSieve


object Euler046 extends Euler {


    val limit = 10000
    val primes = primesSieve().takeWhile(_ < limit).toSet

    val composites = (3 to limit by 2).filterNot(primes.contains)

    def goldbach =
        (for {
            p <- primes
            n <- (1 to 100)
        } yield p + 2 * n * n).toSet

    val result = composites.filterNot(goldbach.contains).min
}
