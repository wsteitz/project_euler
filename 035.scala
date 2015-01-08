package euler

import Primes.isPrime

object Euler035 extends Euler{

    def circle(i: Int) = {
        val s = i.toString
        (0 to s.size).map(i => (s.substring(i, s.size) + s.substring(0, i)).toInt)
    }


    def isCircularPrime(i: Int): Boolean = {
        val s = i.toString
        (0 to s.size).forall(i =>
                isPrime((s.substring(i, s.size) + s.substring(0, i)).toInt))
    }

    val n = 1000000
    val result = (2 to n).filter(isPrime)
                         .filter(_.toString.union("02468").size != 0)
                         .count(isCircularPrime)
}
