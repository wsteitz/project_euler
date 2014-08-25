
package euler


object Euler040 extends Euler {

    val d = (0 to 1000000).map(_.toString).mkString
    val result = (1 to 6).map(math.pow(10, _).toInt)
                         .map(d(_).asDigit).product


}
