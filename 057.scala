
package euler

import Primes._


object Euler057 extends Euler {

    def calc(iter: Int): BigFraction =
        if (iter == 0) BigFraction(0, 0)
        else BigFraction(1, 1) / (calc(iter - 1) + 2)

    val result = (1 to 1000).map(calc(_) + 1)
                            .count(bf => bf.n.toString.size > bf.d.toString.size)
}
