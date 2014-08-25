package euler


object Tools {

  def digits(n: Int) = n.toString.map(_.asDigit)

  def binomialCoefficient(n: Long, k: Int) =
    (BigInt(n - k + 1) to n).product / (BigInt(1) to k).product

  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

}
