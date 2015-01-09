package euler

import Primes.primeFactors
import Primes.isPrime


object Euler047 extends Euler {

    def groupedPrimeFactors(n: Int) =
        primeFactors(n).groupBy(identity)
                       .values
                       .map(v => v.foldLeft("")(_ + _))
                       .toList
                       .sorted

    val factors = (2 to 200000).map(n => (n, groupedPrimeFactors(n))).toMap

    val len = 4
    val result = ( for {
            i <- 5 to 200000 - len
            nums = (0 until len).map(i + _)
             if nums.forall(!isPrime(_)) &&
                nums.forall(factors(_).size == len) &&
                nums.combinations(2)
                    .forall(c => factors(c(0)).intersect(factors(c(1))).size == 0)
              }
             yield nums).head.head

}
