
package euler

import Memoize._


object Euler081 extends Euler {

   val input = scala.io.Source.fromFile("data/p081_matrix.txt")
   val matrix = input.getLines.map(_.split(",").map(_.toInt).toArray).toArray

    lazy val rec: (Int, Int) => Int = memoize{
      (i, j) =>
        if (i == 0 && j == 0) matrix(0)(0)
        else if (i == 0) matrix(i)(j) + rec(i, j -1)
        else if (j == 0) matrix(i)(j) + rec(i - 1, j)
        else matrix(i)(j) + math.min(rec(i, j -1), rec(i - 1, j))
    }

   val result = rec(matrix.size - 1, matrix.size - 1)
}


object Euler081b extends Euler {
   import Graphs._

   val input = scala.io.Source.fromFile("data/p081_matrix.txt")
   val matrix = input.getLines.map(_.split(",").map(_.toInt).toArray).toArray

   val root = (-1, -1)
   val edges = Edge(root, (0, 0), matrix(0)(0)) +:
        (for {
       i <- 0 until matrix.size
       j <- 0 until matrix.size
       offset <- List((1, 0), (0, 1))
       if i + offset._1 < matrix.size &&
          j + offset._2 < matrix.size
   } yield Edge((i, j), (i + offset._1, j + offset._2),
                matrix(i + offset._1)(j + offset._2)))

   val result = dijkstra(edges.toList, root, (matrix.size - 1, matrix.size - 1))._1

}

