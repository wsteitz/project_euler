object euler_50 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  def isPrime(n: Int): Boolean = {
    val ceiling = math.sqrt(n.toDouble).toInt
    (2 until ceiling) forall (x => n % x != 0)
  }                                               //> isPrime: (n: Int)Boolean
  
  
	Range(0, 100).filter(isPrime(_))          //> res0: scala.collection.immutable.IndexedSeq[Int] = Vector(0, 1, 2, 3, 4, 5, 
                                                  //| 6, 7, 8, 9, 11, 13, 15, 17, 19, 23, 25, 29, 31, 35, 37, 41, 43, 47, 49, 53, 
                                                  //| 59, 61, 67, 71, 73, 79, 83, 89, 97)
        
	  	
     
}