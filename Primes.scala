package euler

import Memoize._


object Primes {

  lazy val isPrime: Int => Boolean = memoize{
    n => if (n <= 1) false
         else if (n <= 3) true
         else (2 until math.sqrt(n).toInt + 1).forall(n % _ != 0)
  }

  val primes = (2 to 10000).filter(isPrime).toList

  def primeFactors(number: Int) = {
    def rec(n: Int, ps: List[Int]): List[Int] =
        if (isPrime(n)) List(n)
        else if (n % ps.head == 0) ps.head :: rec(n / ps.head, ps)
        else rec(n, ps.tail)

    if (number == 1) Seq(number)
    else rec(number, primes)
  }


}
