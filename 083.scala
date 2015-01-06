
package euler

import Graphs._


object Euler083 extends Euler {

   val input = scala.io.Source.fromFile("data/p083_matrix.txt")
   val matrix = input.getLines.map(_.split(",").map(_.toInt).toArray).toArray

   val root = (-1, -1)
   val edges = Edge(root, (0, 0), matrix(0)(0)) +:
      (for{
       i <- 0 until matrix.head.size
       j <- 0 until matrix.size
       offset <- List((1, 0), (0, 1), (-1, 0), (0, -1))
       if i + offset._1 < matrix.size &&
          j + offset._2 < matrix.size &&
          i + offset._1 >= 0 &&
          j + offset._2 >= 0
   } yield Edge((i, j), (i + offset._1, j + offset._2),
                matrix(i + offset._1)(j + offset._2)))

   val result = dijkstra(edges.toList, root, (matrix.size - 1, matrix.size - 1))._1

}

