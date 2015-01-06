package euler

object Euler024 extends Euler {

    val result = List(0,1,2,3, 4, 5, 6 ,7, 8, 9).permutations.take(1000000).mkString.size

}
