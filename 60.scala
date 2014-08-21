
def isPrime(i: Int): Boolean =
    if (i <= 1) false
    else if (i <= 3) true
    else (2 until math.sqrt(i).toInt + 1).forall(i % _ != 0)


val primes = (3 to 10000).filter(isPrime)
val n = 5


def isPrimeSeqValid(a: Int, b: Int): Boolean = {
    val sa = a.toString
    val sb = b.toString
    isPrime((sa + sb).toInt) && isPrime((sb + sa).toInt)
}


val validMap = primes.map(a => (a, primes.filter(b => isPrimeSeqValid(a, b))))
                     .toMap

val res2 = (for {
        a <- validMap.keys
        b <- validMap(a)
        if a < b
        } yield (List(a, b).sorted, validMap(a).intersect(validMap(b))))
     .filter(_._2.size >= n - 2)
     .toMap

val res3 = (for {
        as <- res2.keys
        b <- res2(as)
        if b > as.reverse.head
        } yield (as :+ b, res2(as).intersect(validMap(b))))
    .filter(_._2.size >= n - 3)
    .toMap

val res4 = (for {
        as <- res3.keys
        b <- res3(as)
        if b > as.reverse.head
        } yield (as :+ b, res3(as).intersect(validMap(b))))
    .filter(_._2.size >= n - 4)
    .toMap

val res = res4.map(t => t._1 :+ t._2.head)


println(res.map(_.sum).min)
