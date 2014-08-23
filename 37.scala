package euler

object Euler037 extends Euler {

    def isPrime(i: Int): Boolean =
      if (i <= 1) false
      else if (i <= 3) true
      else (2 until math.sqrt(i).toInt + 1).forall(i % _ != 0)

    def truncations(i: Int) =
        (1 to i.toString.size).flatMap(multiplier => {
        val help = math.pow(10, multiplier).toInt
        List(i % help, i / help)
        }).filter(_ > 0).distinct


    def isTruncatablePrime(i: Int): Boolean = {
        truncations(i).forall(isPrime)
    }

    val n = 1000000

    val result = (10 to n).filter(isTruncatablePrime(_)).sum

}
