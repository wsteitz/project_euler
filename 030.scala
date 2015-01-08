package euler

import Tools.digits


object Euler030 extends Euler {

  val power = 5
  val limit = 200000

  def check_sum(n: Int) = Tools.digits(n).map(math.pow(_, power)).sum.toInt == n
  val result = (2 to limit).filter(check_sum).sum
}
