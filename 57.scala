
package euler

import Primes._


object Euler057 extends Euler {


    case class BigFraction(val numerator: BigInt, val denominator: BigInt) {

        def this(numerator: Int, denominator: Int) =
                this(BigInt(numerator), BigInt(denominator))

        def +(i: Int):BigFraction =
            if (denominator == 0) BigFraction(i, 1)
            else BigFraction(numerator + i * denominator, denominator)

        def /(other: BigFraction):BigFraction =
            BigFraction(numerator * other.denominator, other.numerator * denominator)
    }


    def calc(iter: Int): BigFraction =
        if (iter == 0) BigFraction(0, 0)
        else BigFraction(1, 1) / (calc(iter - 1) + 2)


    val result = (1 to 1000).map(calc(_) + 1)
                            .filter(bf => bf.numerator.toString.size >
                                          bf.denominator.toString.size)
                            .size


}
