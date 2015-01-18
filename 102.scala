package euler


object Euler102 extends Euler {

    val origin = (0, 0)

    def triangleArea(a: (Int, Int), b: (Int, Int), c: (Int, Int)) =
        math.abs((a._1 * (b._2 - c._2) + b._1 * (c._2 - a._2) + c._1 * (a._2 - b._2)) / 2.0)

    def originContained(coords: Seq[Int]) = {
        val a = (coords(0), coords(1))
        val b = (coords(2), coords(3))
        val c = (coords(4), coords(5))
        val a0 = triangleArea(a, b, c)
        val a1 = triangleArea(a, b, origin)
        val a2 = triangleArea(a, c, origin)
        val a3 = triangleArea(b, c, origin)
        math.abs(a0 - a1 - a2 - a3) <= 0.000001
    }

    val input = scala.io.Source.fromFile("data/p102_triangles.txt")
    val result = input.getLines.map(_.split(",").map(_.toInt).toSeq).count(originContained)
}
