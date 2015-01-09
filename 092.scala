package euler

import Tools.digits
import Memoize._


object Euler092 extends Euler {


  lazy val numberChain: Int => Boolean = memoize{
    n => if (n == 1) false
         else if (n == 89) true
         else numberChain(digits(n).map(d => d * d).sum)
  }

  val result = (1 to 10000000).count(numberChain)

}
