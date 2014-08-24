
package euler

import Memoize._


object Euler082 extends Euler {

   def input = scala.io.Source.fromFile("data/p082_matrix.txt")
   def matrix = input.getLines.map(_.split(",").map(_.toInt).toArray).toArray

    lazy val rec: (Int, Int, Int) => Int = memoize{
      (i, j, k) =>
        if (j == 0) matrix(i)(j)
        else if (i == 0) matrix(i)(j) +
                (if (k == -1) rec(i, j - 1, 0) else math.min(rec(i, j - 1, 0), rec(i + 1, j, 1)))
        else if (i == matrix.size - 1) matrix(i)(j) +
                (if (k == 1) rec(i, j -1, 0) else  math.min(rec(i, j - 1, 0), rec(i - 1, j, -1)))
        else matrix(i)(j) + {if (k == 1) math.min(rec(i, j -1, 0), rec(i + 1, j, 1))
                             else (if (k == -1) math.min(rec(i, j -1, 0), rec(i - 1, j, -1))
                              else math.min(math.min(rec(i, j -1, 0), rec(i - 1, j, -1)), rec(i + 1, j, 1)))}
    }

   val result = (0 until matrix.size).map(i => rec(i, matrix.size - 1, 0)).min
}


object Euler082b extends Euler {
   import Graphs._

   def input = scala.io.Source.fromFile("data/p082_matrix.txt")
   def matrix = input.getLines.map(_.split(",").map(_.toInt).toArray).toArray

   val root = (-1, -1)
   val exit = (-2, -2)
   val edges_in = for(i <- 0 until matrix.size) yield Edge(root, (i, 0), matrix(i)(0))
   val edges_out = for(i <- 0 until matrix.size) yield Edge((i, matrix.size - 1), exit, 0)
   val edges = for {
       i <- 0 until matrix.head.size
       j <- 0 until matrix.size
       offset <- List((1, 0), (0, 1), (-1, 0))
       if i + offset._1 < matrix.head.size &&
          j + offset._2 < matrix.size &&
          i + offset._1 >= 0 &&
          j + offset._2 >= 0
   } yield Edge((i, j), (i + offset._1, j + offset._2),
                matrix(i + offset._1)(j + offset._2))

   val result = dijkstra(edges.toList ++ edges_in.toList ++ edges_out.toList, root, exit)._1

}

