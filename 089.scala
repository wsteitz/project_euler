package euler

object Euler089 extends Euler {

    val numerals = List(("M", 1000), ("CM", 900), ("D", 500), ("CD", 400), ("C", 100), ("XC", 90),
                        ("L", 50), ("XL", 40), ("X", 10), ("IX", 9), ("V", 5), ("IV", 4), ("I", 1))

    def roman(num: Int): String =
        numerals.find{case (l, n) => n <= num}
                .map{case (l, n) => l + roman(num - n)}
                .getOrElse("")

    def arabic(s: String): Int =
        numerals.find{case (l, n) => s.startsWith(l)}
                .map{case (l, n) => n + arabic(s.drop(l.size))}
                .getOrElse(0)

    val input = scala.io.Source.fromFile("data/p089_roman.txt")
    val result  = input.getLines.map(s => s.size - roman(arabic(s)).size).sum
}
