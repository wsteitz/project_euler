package euler

import Primes.isPrime


object Euler037 extends Euler {

    def truncations(i: Int) =
        (1 to i.toString.size).flatMap(multiplier => {
        val help = math.pow(10, multiplier).toInt
        List(i % help, i / help)
        }).filter(_ > 0).distinct


    def isTruncatablePrime(i: Int): Boolean = {
        truncations(i).forall(isPrime)
    }

    val n = 1000000

    val result = (10 to n).filter(isTruncatablePrime(_)).sum

}
