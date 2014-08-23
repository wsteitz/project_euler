
package euler
import Memoize._


object Euler114 extends Euler {

    def countPermutations(width: Int) = {

        lazy val rec: (Int, Int) => Long = memoize{
            (w, last) => {
                if (w == 0) 1
                else if (w < 0) 0
                else if (last >= 3) rec(w - 1, 1)
                else ((3 to w) :+ 1).map(n => rec(w - n, n)).sum
            }
        }
        rec(width, 0)
    }

    val width = 50
    val result = countPermutations(width)
}

