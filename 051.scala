package euler

import Primes.isPrime


object Euler051 extends Euler {

    def hasOnes(i: Int) = i.toString.contains('1')

    def getPrimes(i: Int) = {
        val s = i.toString
        val pos = if (s.head == '1') "123456789" else "0123456789"
        for {
            i <- pos
            n = s.replace('1', i).toInt
            if isPrime(n)
        } yield n
    }

    def criteria(i: Int): Boolean =
        i % 2 != 0 && i.toString.head.asDigit <= 2 && hasOnes(i) && getPrimes(i).size >= 8

    val result = Stream.from(10).find(criteria).get
}
