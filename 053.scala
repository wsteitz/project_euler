package euler

import Tools.binomialCoefficient


object Euler053 extends Euler {

  val result = (for {
                n <- 1 to 100
                r <- 1 to n
                if binomialCoefficient(n, r) > 1000000}
                yield 1).sum
}
