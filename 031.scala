package euler

import Memoize._


object Euler031 extends Euler {

    val coins: List[Int] = List(1, 2, 5, 10, 20, 50, 100, 200)

    lazy val split: (Int, Int) => Int = Memoize.memoize{
      (rest, last) =>
        if (rest == 0) 1
        else coins.filter(c => c <= last && c <= rest)
                  .map(c => split(rest -c, c)).sum
    }

    val result = split(200, 200)

}
