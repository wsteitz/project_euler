

import scala.io.Source



val distances = (for {
    (line, v1) <- io.Source.fromFile("p107_network.txt").getLines.zipWithIndex
    (weight, v2) <- line.split(",").iterator.zipWithIndex
    if weight != "-" && v1 < v2} yield (v1, v2, weight.toInt) ).toList


def mst(tree: Set[Int]): List[(Int, Int, Int)] = {
    if (tree.size != 40) {
    
        val next1 = distances.filter(elem => tree.contains(elem._1) != tree.contains(elem._2))
        val next = next1.sortBy(_._3).head
        next :: mst(tree + next._1 + next._2)
    }
    else Nil
}


val res = mst(Set(0))

println(distances.map(_._3).sum - res.map(_._3).sum)
