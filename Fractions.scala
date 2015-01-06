package euler

import Tools.gcd

case class BigFraction(val n: BigInt, val d: BigInt=BigInt(1)) {

    def this(n: Int, d: Int) = this(BigInt(n), BigInt(d))

    def +(that: BigFraction):BigFraction =  new BigFraction(n * that.d + that.n * d, d * that.d)

    def +(i: Int):BigFraction =
        if (d == 0) BigFraction(i, 1) else BigFraction(n + i * d, d)

    def /(other: BigFraction):BigFraction = BigFraction(n * other.d, other.n * d)

    def reciprocal = BigFraction(d, n)
}
