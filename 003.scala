package euler

import Primes.primesSieve


object Euler003 extends Euler {

    val value = 600851475143L
    val limit = math.sqrt(value).toInt
    val primes = primesSieve().takeWhile(_ < limit).reverse
    val result = primes.find(value % _ == 0).get
}
