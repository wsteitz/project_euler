package euler

import Tools.binomialCoefficient


object Euler113 extends Euler {

    val digits = 100

    val incs = binomialCoefficient(10 + digits - 1, digits) - 1
    val decs = binomialCoefficient(10 + digits, digits) - 1 - digits
    val dups = 9 * digits

    val result = incs + decs - dups


}
