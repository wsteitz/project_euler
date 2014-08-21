

def isPrime(i: Int): Boolean =
    if (i <= 1) false
    else if (i <= 3) true
    else (2 until math.sqrt(i).toInt + 1).forall(i % _ != 0)

val limit = 10000
val primes = (2 to limit).filter(isPrime)
val primesLookup = primes.toSet




def primSums(ps: List[Int], acc: Int, len: Int): List[(Int, Int)] = {
    if (acc > limit) Nil
    else if (ps.isEmpty) Nil
    else {
        if (primesLookup.contains(acc) && len > 1) (acc, len) +: primSums(ps.tail, acc + ps.head, len + 1)
        else primSums(ps.tail, acc + ps.head, len + 1)

    }

}


def findPrimSums(primes: List[Int]): List[(Int, Int)] = {
     primes match {
        case Nil => Nil
        case ps => findPrimSums(ps.tail) ++ primSums(ps, 0, 0)
    }
}



val res = findPrimSums(primes.toList)
println(res.sortBy(_._2))



