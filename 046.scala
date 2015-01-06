package euler

object Euler046 extends Euler {


    def isPrime(i: Int): Boolean =
        if (i <= 1) false
        else if (i <= 3) true
        else (2 until math.sqrt(i).toInt + 1).forall(i % _ != 0)


    val limit = 10000
    val primes = (1 to limit).filter(isPrime).toSet
    val composites = (1 to limit by 2).filter(!primes.contains(_))

    def goldbach =
        (for {
            p <- primes
            n <- (1 to 100)
        } yield p + 2 * n * n).toSet



    val result = composites.filter(!goldbach.contains(_))

}
