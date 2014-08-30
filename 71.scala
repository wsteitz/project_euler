
package euler

import Tools.gcd


object Euler073 extends Euler {

    val result = (for {
        d <- 3 to 12000
        n <- d / 3 to d / 2
        if gcd(d, n) == 1 && n.toDouble / d > 1.0 / 3
    } yield 1).sum
}


