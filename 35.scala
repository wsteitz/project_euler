
package euler


object Euler035 extends Euler{

    def isPrime(i: Int): Boolean =
      if (i <= 1) false
      else if (i <= 3) true
      else (2 until math.sqrt(i).toInt + 1).forall(i % _ != 0)

    def circle(i: Int) =
      (0 to i.toString.size - 1).map(multiplier => {
        val help = math.pow(10, multiplier).toInt
        ((i % help).toString + (i / help).toString).toInt})


    def isCircularPrime(i: Int): Boolean = {
      circle(i).forall(isPrime(_))
    }

    val n = 1000000

    val res = (2 to n).filter(isCircularPrime(_))
    val result = res.size

}
