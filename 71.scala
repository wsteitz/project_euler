
package euler

import Tools.gcd


object Euler071 extends Euler {

    val max = 3.0 / 7

    val fractions = (for {
        den <- 1 to 1000000
        num = (den * 3 - 1) / 7
    } yield (num, den))


    val min = fractions.minBy(t => max - t._1.toDouble / t._2)
    val result = min._1

}


