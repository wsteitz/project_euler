
package euler

// the min and max


object Euler206 extends Euler {

    def test(n: Int) =
        // last digit of the square is a nine => 3 or 7 needed
        if ((n % 10) != 3 && (n % 10) != 7) false
        else (n.toLong * n).toString.matches("1.2.3.4.5.6.7.8.9")

    // min and max values are the square roots of all blanks filled with zeros or all nines
    val min = math.sqrt(10203040506070809L).toInt
    val max = math.sqrt(19293949596979899L).toInt
    // the results needs to end in 0 => the last digits is zero
    val result = (min to max).find(test).get * 10
}
