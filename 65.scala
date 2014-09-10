
package euler

import Memoize._

object Euler065 extends Euler {

  def a(pos: Int) =
    if (pos % 3 == 2) 2 * ( pos + 1 ) / 3 else 1

  lazy val numerator: Int => BigInt = memoize{pos =>
      if (pos == 1) BigInt(2)
      else if (pos == 2) BigInt(3)
      else a(pos - 1) * numerator(pos - 1) + numerator(pos - 2)
  }

  def result = numerator(100).toString.map(_.asDigit).sum

}
