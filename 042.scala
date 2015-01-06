
package euler


object Euler042 extends Euler {

    def triangle(n: Int) = n * ( n + 1) / 2

    val triangles = (1 to 100000).map(triangle).toSet

    def wordValue(s: String) = s.map(_.toInt - 64).sum

    def isTriangleWord(s: String) = triangles contains wordValue(s)

    def input = scala.io.Source.fromFile("data/p042_words.txt")
    val words = input.getLines.mkString.split(",").map(_.replace("\"", ""))

    val result = words.count(isTriangleWord)

}
