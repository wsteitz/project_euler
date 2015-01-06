
package euler

import Tools.gcd


object Euler033 extends Euler {

    def curiousSimplify(frac: (Int, Int)) = {
        val common = frac._1.toString.intersect(frac._2.toString)
        val n = frac._1.toString.filter(c => !common.contains(c))
        val d = frac._2.toString.filter(c => !common.contains(c))

        if (n == "" || d == "") (0, 0)
        else (n.toInt, d.toInt)
    }

    def isCurious(frac: (Int, Int)) = {
        val simple = curiousSimplify(frac)
        if (simple._1 == 0 || simple._2 == 0) false
        else if (simple._1 == frac._1) false
        else simple._1 / simple._2.toDouble == frac._1 / frac._2.toDouble
    }

    val curious =
       (for {
        num <- 10 to 99
        denom <- 10 to 99
        if num < denom &&
           num % 10 != 0 &&
           denom % 10 != 0
        } yield (num, denom))
       .filter(isCurious)

    def simplify(frac: (Int, Int)) = {
        val g = gcd(frac._1, frac._2)
        (frac._1 / g, frac._2 / g)
    }

    println(curious)
    val result = simplify(curious.map(_._1).product, curious.map(_._2).product)._2

}
