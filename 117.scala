
package euler
import Memoize._


object Euler117 extends Euler{

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

    val width = 50
    val result = countPermutations(width)
}

