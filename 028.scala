
package euler


object Euler028 extends Euler{

    def nextPos(pos: (Int, Int), dir: String) =
        if (dir == "right")
            (pos._1, pos._2 + 1)
        else if (dir == "down")
            (pos._1 + 1, pos._2)
        else if (dir == "left")
            (pos._1, pos._2 - 1)
        else
            (pos._1 - 1, pos._2)


    def nextDir(dir: String) =
        if (dir == "right")
            "down"
        else if (dir == "down")
            "left"
        else if (dir == "left")
            "up"
        else
           "right"


    def prevDir(dir: String) =
        if (dir == "right")
            "up"
        else if (dir == "down")
            "right"
        else if (dir == "left")
            "down"
        else
           "left"



    def populate(pos: (Int, Int), i: Int, dir: String): Unit =
        if (i <= n * n) {
            pos match { case (x, y) =>
                matrix(x)(y) = i

                val next_pos = nextPos(pos, dir)
                if (matrix(next_pos._1)(next_pos._2) == 0)
                    populate(next_pos, i + 1, nextDir(dir))
                else
                    populate(nextPos(pos, prevDir(dir)), i + 1, dir)
            }
        }


    val n = 1001
    val matrix = Array.ofDim[Long](n, n)

    val middle = n / 2
    populate((middle, middle), 1, "right")

    val result = (0 until n).map(i => matrix(i)(i) + matrix(i)(n - i - 1)).sum - 1

}
