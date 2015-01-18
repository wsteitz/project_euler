package euler

object Euler097 extends Euler {

    val mod = 10000000000L
    val result = (28433 * BigInt(2).modPow(7830457, mod) + 1) % mod;
}
