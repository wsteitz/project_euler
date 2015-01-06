
package euler

import Primes._

// spiral code from 28.scala could be replaced with something similar


object Euler058 extends Euler{

    def search(size: Int, acc: Int): Int =
        if (acc.toDouble / (2 * size + 1) < 0.10) size
        else {
            val max = size * size
            val new_primes = List(max, max - (size - 1), max - 2 * (size - 1), max - 3 * (size - 1))
                .filter(isPrime).size
            search(size + 2, acc + new_primes)
    }

    val result = search(5, 3)
}
