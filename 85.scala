
package euler

import Memoize._


object Euler085 extends Euler {


    lazy val countRectangles: (Int, Int) => Int = Memoize.memoize{
      (w, h) => {
        if (w == 1 && h == 1) 1
        else if (w == 0 || h == 0) 0
        else if (h == 1) w * h + countRectangles(w - 1, h)
        else if (w == 1) w * h + countRectangles(w, h - 1)
        else w * h + countRectangles(w - 1, h - 1) +
             h * countRectangles(w - 1, 1) + w * countRectangles(1, h - 1)
        }
    }

    val result = (for {
        w <- 1 to 100
        b <- 1 to 100
        } yield (w * b, countRectangles(w, b)))
        .minBy(n => math.abs(n._2 - 2000000))._1

}
