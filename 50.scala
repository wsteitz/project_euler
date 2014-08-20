  
  
def isPrime(i: Int): Boolean =
  if (i <= 1) false
  else if (i <= 3) true
  else (2 until math.sqrt(i).toInt + 1).forall(i % _ != 0)
  
  

val n = 1000
val primes = Range(0, n).filter(isPrime(_)).toList     
val primesSet = primes.toSet



def primSumRec(primes: List[Int], acc: Int, len: Int): List[(Int, Int)] = {
    if (acc > n) Nil
    
    else {

     val sol = if (primesSet.contains(acc)) (acc, len) else (0, 0)
     
      primes match {
        case Nil => List(sol)
        case p :: ps => sol +: primSumRec(ps.tail, acc + p, len + 1)
     }   
    }
}


def primSum(primes: List[Int]): List[(Int, Int)] = {
    primes foldLeft primSumRec(_, 0, 0)
}

  
  
val res = primSum(primes)


println(res.sortBy(_._2).reverse.head)
