
package euler

import Memoize._


object Euler076 extends Euler {

    lazy val ways: (Int, Int) => Int = memoize{

        (n, max) =>
            if (n == 0) 1
            else if (n == 1) 1
            else if (max == 1) max
            else (1 to math.min(n, max)).map(i => ways(n - i, i)).sum

    }

    val n = 100
    val result = (1 until n).map(i => ways(n - i, i)).sum

}
