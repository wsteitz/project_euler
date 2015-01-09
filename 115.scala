
package euler
import Memoize._


object Euler115 extends Euler{

    def countPermutations(minw: Int, width: Int) = {

        lazy val rec: (Int, Int) => Long = memoize{
            (w, last) => {
                if (w == 0) 1
                else if (w < 0) 0
                else if (last >= 3) rec(w - 1, 1)
                else ((minw to w) :+ 1).map(n => rec(w - n, n)).sum
            }
        }
        rec(width, 0)
    }

    val m = 50
    val limit = 1000000
    val result = (0 to 1000).find(n => countPermutations(m, n) > limit).getOrElse("")
}

