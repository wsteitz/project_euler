
package euler

import Primes._
import Memoize._


object Euler077 extends Euler {

    val primes = (1 to 100000 by 2).filter(isPrime)

    lazy val count: (Int, Int) => Int = Memoize.memoize{
        (n, last) => {
            if (n == 0) 1
            else if (n == 1 || n < 0) 0
            else (for {p <- primes.takeWhile(_ <= last)} yield count(n - p, p)).sum
        }
    }

    val result = (1 to 10000).find(n => count(n, n) > 5000)

}

