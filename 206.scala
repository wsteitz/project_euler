
package euler


object Euler206 extends Euler {

    val positions = Seq(0, 2, 4, 6, 8, 10, 12, 14, 16)

    def matchPattern(l: Long) = {
        val s = l.toString
        positions.map(s(_)).mkString == "123456789"
    }

    def test(n: Long): Boolean = {
        val last_digit = n % 10
        // last digit of the square is a nine => 3 or 7 needed
        (last_digit == 3 || last_digit == 7) && matchPattern(n * n)
    }

    // min and max values are the square roots of all blanks filled with zeros or all nines
    val min = math.sqrt(10203040506070809L).toLong
    val max = math.sqrt(19293949596979899L).toLong
    // the results needs to end in 0 => the last digits is zero
    val result = (min to max).find(test).get * 10
}
