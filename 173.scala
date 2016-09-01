package euler

import Memoize._


object Euler173 extends Euler {

  val tiles = 1000000

  lazy val counter: (Int, Int) => Int = Memoize.memoize{
    (n, w) => {
      if (n < w * 4 || n < 8 || w < 2) 0 else 1 + counter(n - w * 4, w - 2)
    }
  }

  val result = (2 to tiles / 4).map(i => counter(tiles, i)).sum
  
}
