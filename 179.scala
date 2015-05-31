package euler

import Math._
import Primes.primeFactors


object Euler179 extends Euler {
    
    
  // unused  
  def divisorCount(n: Int) = primeFactors(n).groupBy(identity).values.map(_.size + 1).fold(1)(_ * _)
   
  val n = Math.pow(10, 7).toInt
  
  val counts = Array.ofDim[Int](n + 1)
  
  for {i <- 1 to n
       j <- i to n by i} counts(j) += 1
  
  val result = counts sliding(2) count{ case Array(a, b) => a == b }

}
