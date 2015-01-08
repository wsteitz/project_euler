package euler

import Primes.isPrime


object Euler041 extends Euler {

  // 1. generate all n pandigitals (max 7 digits, larger pandigitals cannot be prime)
  // 2. sort
  // 3. take the first that is prime

  val result =
        (1 to 7).flatMap(n => (1 to n).permutations.map(_.mkString.toInt))
                .sorted.reverse
                .find(isPrime).getOrElse("")
}
