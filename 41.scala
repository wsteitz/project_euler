package euler

object Euler041 extends Euler {


  def isNPandigital(n: Int) = {
    val s = n.toString
    s.sorted == "123456789".substring(0, s.size)
  }

  def isPrime(i: Int): Boolean =
    if (i <= 1) false
    else if (i <= 3) true
    else (2 until math.sqrt(i).toInt + 1).forall(i % _ != 0)


  val result = (100001 to 10000000 by 2).filter(isPrime).filter(isNPandigital).max


}
