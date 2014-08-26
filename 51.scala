
package euler

import Primes._


object Euler051 extends Euler {

    val limit = 1000000

    val primes = (3 to limit by 2).filter(isPrime).toSet

    def countOnes(i: Int) = i.toString.filter(_ == '1').size

    def getPrimes(i: Int) = {
        val s = i.toString
        val pos = if (s.head == '1') "123456789" else "0123456789"
        for {
            i <- pos
            n = s.replace('1', i).toInt
            if primes.contains(n)
        } yield n
    }

    // generates all possible masks and filters those that generate enough primes
    val prime_groups = for {
        i <- 10 to limit
        if i % 2 != 0 &&
           i.toString.head.asDigit <= 2 &&
           countOnes(i) > 0 &&
           getPrimes(i).size >= 8}
        yield i


    val result = getPrimes(prime_groups.min).min
}
