package euler

import Tools.digits
import Memoize._


object Euler092 extends Euler {

  lazy val numberChain: Int => Int = memoize{
        n => n match {
           case 1 => 1
           case 89 => 89
           case n => numberChain(digits(n).map(d => d * d).sum)
       }
  }

  def result = (1 to 10000000).count(numberChain(_) == 89)

}
