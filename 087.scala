
package euler

import Primes._


object Euler087 extends Euler {

    val limit = 50000000
    val primes = (2 +: (3 to math.sqrt(limit).toInt by 2)).filter(isPrime).map(BigInt(_))
    val squares = primes.map(p => p * p).filter(_ < limit)
    val cubes = primes.map(p => p * p * p).filter(_ < limit)
    val fourths = squares.map(p => p * p).filter(_ < limit)

    val result = (for {
        s <- squares
        c <- cubes if s + c < limit
        f <- fourths
        n = s + c + f
        if n < limit
    } yield n).distinct.size

}
