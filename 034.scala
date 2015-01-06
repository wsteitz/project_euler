package euler

import Tools.{digits, factorial}


object Euler034 extends Euler {

    val factMap = (0 to 9).map(n => n -> factorial(n)).toMap

    val res = for {
                   n <- (3 until 100000)
                   if n == digits(n).map(factMap(_)).sum
                  } yield n

    val result = res.sum

}
