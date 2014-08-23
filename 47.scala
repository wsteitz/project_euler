package euler

object Euler047 extends Euler {


    def isPrime(i: Int): Boolean =
        if (i <= 1) false
        else if (i <= 3) true
        else (2 until math.sqrt(i).toInt + 1).forall(i % _ != 0)


    val primes = (2 to 10000).filter(isPrime).toList


    def primeFactors(number: Int) = {

        def rec(n: Int, ps: List[Int]): List[Int] =
            if (isPrime(n)) List(n)
            else if (n % ps.head == 0) ps.head :: rec(n / ps.head, ps)
            else rec(n, ps.tail)

        rec(number, primes).groupBy(identity)
                           .values
                           .map(v => v.foldLeft("")(_ + _))
                           .toList
                           .sorted

    }

    val factors = (2 to 200000).map(n => (n, primeFactors(n))).toMap

    val len = 4
    val result = ( for {
            i <- 5 to 200000 - len
            nums = (0 until len).map(i + _)
             if nums.forall(n => !primes.contains(n)) &&
                nums.forall(factors(_).size == len) &&
                nums.combinations(2)
                    .forall(c => factors(c(0)).intersect(factors(c(1))).size == 0)
              }
             yield nums).take(10)

}
