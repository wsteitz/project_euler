package euler

import Primes.isPrime


object Euler049 extends Euler {

    val primes = (1000 to 10000).filter(isPrime).toSet

    val res = for {
                p1 <- primes
                p2 = p1 + 3330
                p3 = p2 + 3330

                if primes.contains(p2) &&
                   primes.contains(p3) &&
                   p1.toString.sorted == p2.toString.sorted &&
                   p2.toString.sorted == p3.toString.sorted

               } yield List(p1, p2, p3)


    val result = res.map(_.map(_.toString).mkString).head

}
