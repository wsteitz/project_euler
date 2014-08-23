
package euler
import Memoize._


object Euler116 {

    def countPermutations(width: Int, b: Int) = {

        lazy val rec: Int => Long = memoize{
          w =>
            w match {
              case 0 => 1
              case x if x < 0 => 0
              case any => rec(w - 1) + rec(w - b)
            }
        }

        rec(width)
    }

    def main(args: Array[String]) {
        val width = 50
        val res = (2 to 4).map(countPermutations(width, _)).sum - 3
        println(res)
    }
}

