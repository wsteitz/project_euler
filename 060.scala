package euler

import Primes.isPrime
import Primes.primesSieve


object Euler060 extends Euler {

    val primes = primesSieve().takeWhile(_ < 10000)
    val n = 5

    def isPrimeSeqValid(a: Int, b: Int): Boolean = {
        val sa = a.toString
        val sb = b.toString
        isPrime((sa + sb).toInt) && isPrime((sb + sa).toInt)
    }

    val validMap = primes.map(a => (a, primes.filter(b => isPrimeSeqValid(a, b)))).toMap

    val res2 = (for {
            a <- validMap.keys
            b <- validMap(a)
            if a < b
            } yield (List(a, b), validMap(a).intersect(validMap(b))))
         .filter(_._2.size >= n - 2)
         .toMap

    val res3 = (for {
            as <- res2.keys
            tail = as.reverse.head
            b <- res2(as)
            if b > tail
            } yield (as :+ b, res2(as).intersect(validMap(b))))
        .filter(_._2.size >= n - 3)
        .toMap

    val res4 = (for {
            as <- res3.keys
            tail = as.reverse.head
            b <- res3(as)
            if b > tail
            } yield (as :+ b, res3(as).intersect(validMap(b))))
        .filter(_._2.size >= n - 4)
        .toMap

    val res = res4.map(t => t._1 :+ t._2.head)
    val result = res.map(_.sum).min
}
