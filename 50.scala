
package euler


object Euler050 extends Euler{

    def isPrime(i: Int): Boolean =
        if (i <= 1) false
        else if (i <= 3) true
        else (2 until math.sqrt(i).toInt + 1).forall(i % _ != 0)

    val limit = 1000000
    val primes = (2 to limit).filter(isPrime).toList
    val primesLookup = primes.toSet

    def maxPrimSum(ps: List[Int]) =
        ps.scanLeft(0)(_ + _).takeWhile(_ < limit)
                             .zipWithIndex
                             .filter(t => primesLookup.contains(t._1))
                             .maxBy(_._2)

    def findPrimSums(primes: List[Int], acc: Seq[(Int, Int)]): Seq[(Int, Int)] = {
         primes match {
            case Nil => acc
            case ps => findPrimSums(ps.tail, acc :+ maxPrimSum(ps))
        }
    }

    val result = findPrimSums(primes.take(1000), List()).maxBy(_._2)

}
