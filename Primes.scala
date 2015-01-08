package euler

import Memoize._


object Primes {

  lazy val isPrime: Int => Boolean = memoize{
    n => if (n <= 1) false
         else if (n <= 3) true
         else (2 to math.sqrt(n).toInt).forall(n % _ != 0)
  }

   def primesSieve(): Stream[Int] = {
       lazy val ps = 2 #:: sieve(3)
       def sieve(p: Int): Stream[Int] = {
           p #:: sieve(
                Stream.from(p + 2, 2).
                 find(i=> ps.takeWhile(j => j * j <= i).
                         forall(i % _ > 0)).get)
        }
      ps
  }

  lazy val primes = primesSieve().takeWhile(_ < 1000000)

  def primeFactors(number: Int) = {

    def rec(n: Int): List[Int] =
        if (isPrime(n)) List(n)
        else {
            val f = primes.find(n % _ == 0).get
            f :: rec(n / f)
        }

    if (number == 1) Seq(number)
    else rec(number)
  }




}
