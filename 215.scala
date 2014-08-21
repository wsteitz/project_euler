
def getLayers(width: Int) = {

    def rec(width: Int, layer: List[Int]): List[List[Int]] =
        if (width == 0) layer.permutations.toList
        else {
            (for {
                brick <- List(2, 3)
                if brick <= width &&
                   (layer.isEmpty || brick <= layer.head)
            } yield rec(width - brick, brick +: layer)
            ).flatten
        }

    rec(width, List())
}


def countWalls(width: Int, height: Int) = {

    val layersRaw = getLayers(width).zipWithIndex
    val cuts = layersRaw.map(l => l._2 -> l._1.scanLeft(0)(_ + _)).toMap

    def fits(layer1: Int, layer2: Int) =
        cuts(layer1).intersect(cuts(layer2)).size <= 2

    val layers = layersRaw.map(_._2)
    val fitMap = layers.map(l1 => (l1 -> layers.filter(l2 => fits(l1, l2)))).toMap

    def rec(height: Int, top: List[(Int, BigInt)]): Long = {
        if (height == 1) top.map(_._2.toLong).sum
        else {
            val wall = (for {
                (l1, count) <- top
                l2 <- fitMap(l1)
            } yield (l2, count))
                   .groupBy(_._1)
                   .mapValues(_.map(_._2).sum)
                   .toList
            rec(height - 1, wall)
        }
    }
    rec(height, layers.map(_ -> BigInt(1)))
}


println(countWalls(32, 10))
//println(countWalls(32, 10))

