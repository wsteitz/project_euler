package euler

import Tools.{digits, factorial}
import Memoize._


object Euler074 extends Euler {

    val factMap = (0 to 9).map(factorial).toVector

    val known = Map((169, 3), (871, 2), (872, 3),  (145, 1),
                    (363600, 3), (1454, 3), (45361, 2), (45362, 2))

    lazy val chainSize: Int => Int = memoize{
        n => known.get(n) match {
            case Some(k) => k
            case None =>
                 val next = digits(n).map(factMap).sum
                 if (next == n) 1 else 1 + chainSize(next)
            }
        }

    val result = (1 to 1000000).count(chainSize(_) == 60)

}
