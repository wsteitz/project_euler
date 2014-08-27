package euler

import Memoize._


object Primes {

  lazy val isPrime: Int => Boolean = memoize{
    n => if (n <= 1) false
         else if (n <= 3) true
         else (2 to math.sqrt(n).toInt).forall(n % _ != 0)
  }

  val primes = 2 +: (3 to 1000000 by 2).filter(isPrime).toList

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
