package euler


object Euler151 extends Euler {

    def count(a2: Int, a3: Int, a4: Int, a5: Int): Double = {
        val sheets = a2 + a3 + a4 + a5
        if (sheets == 0 || a2 < 0 || a3 < 0 || a4 < 0 || a5 < 0) 0
        else {
            val singles = (if (sheets == 1 && a5 == 0) 1 else 0) +
                a2 * count(a2 - 1, a3 + 1, a4 + 1, a5 + 1) +
                a3 * count(a2, a3 - 1, a4 + 1, a5 + 1) +
                a4 * count(a2, a3, a4 - 1, a5 + 1) +
                a5 * count(a2, a3, a4, a5 - 1)
            singles.toDouble / sheets
        }
    }

    val result = "%1.6f" format count(1, 1, 1, 1)

}
