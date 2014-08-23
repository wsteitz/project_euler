
package euler
import Memoize._


object Euler117 {

    def countPermutations(width: Int) = {

        lazy val rec: Int => Long = memoize{
          w =>
            w match {
              case 0 => 1
              case x if x < 0 => 0
              case any => (1 to 4).map(b => rec(w - b)).sum
            }
        }

        rec(width)
    }

    def main(args: Array[String]) {
        val width = 50
        val res = countPermutations(width)
        println(res)
    }
}

