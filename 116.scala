
package euler
import Memoize._


object Euler116 extends Euler{

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

    val width = 50
    val result = (2 to 4).map(countPermutations(width, _)).sum - 3
}

