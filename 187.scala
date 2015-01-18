
package euler

import Primes.primesSieve


object Euler187 extends Euler {

    val limit = 100000000
    val primes = primesSieve().takeWhile(_ < limit / 2)
    val sqrt = math.sqrt(limit).toInt
    val result = primes.takeWhile(_ < sqrt).map(p => primes.dropWhile(_ < p).takeWhile(_ * p <= limit).size).sum

}
