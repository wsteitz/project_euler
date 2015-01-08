
package euler

import Primes.isPrime


object Euler050 extends Euler{

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

    val result = findPrimSums(primes.take(1000), List()).maxBy(_._2)._1

}
