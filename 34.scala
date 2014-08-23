package euler

import Tools.digits


object Euler034 extends Euler {


    def factorial(n: Int): Int =
       if (n <= 1) 1
       else n * factorial(n - 1)

    val factMap = (0 to 9).map(n => n -> factorial(n)).toMap

    val res = for {
                   n <- (3 until 100000)
                   if n == digits(n).map(factMap(_)).sum
                  } yield n

    val result = res.sum

}
