package euler

import Memoize._


object Euler002 extends Euler {

    lazy val fib: Int => Int = memoize{
      i => if (i <= 2) i
           else fib(i - 1) + fib(i - 2)
    }

    val result = Stream.from(2).map(fib).takeWhile(_ < 4000000).filter(_ % 2 == 0).sum
}
