package euler

import Tools.bigFactorial
import Tools.bigDigits


object Euler020 extends Euler {

    val result = bigDigits(bigFactorial(BigInt(100))).sum
}
