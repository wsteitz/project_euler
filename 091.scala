package euler

object Euler091 extends Euler {

    def square(d: Double) = d * d

    def distance(x1: Int, y1: Int, x2: Int, y2: Int): Double =
        math.sqrt(square(x2 - x1) + square(y2 - y1))

    def isSolution(sides: List[Double]): Boolean = {
        val List(a, b, c) = sides.sorted
        math.abs(a * a + b * b - c * c) <= 0.001
    }

    val size = 50
    val result = (for {
        x1 <- 0 to size
        y1 <- 0 to size
        a = distance(x1, y1, 0, 0)
        x2 <- x1 to size
        y2 <- 0 to size
        if (x1 < x2 || y1 < y2) && x1 + y1 != 0
        b = distance(x2, y2, 0, 0)
        c = distance(x1, y1, x2, y2)
        if isSolution(List(a, b, c))
    } yield 1).size
}
