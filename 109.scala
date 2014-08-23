package euler

object Euler109 extends Euler {

    val bulls = List(("B", 25, false), ("DB", 50, true)) ++ List(("Nix", 0, false))
    val fields = (1 to 20).flatMap(v => List((v.toString, v, false),
                                             ("D" + v.toString, v * 2, true),
                                             ("T" + v.toString, v * 3, false))) ++ bulls
    val sol =
        for {
        d1 <- fields
        d2 <- fields
        d3 <- fields
        sum = d1._2 + d2._2 + d3._2
        if (sum < 100 && d3._3 && d1._2 <= d2._2 && (d1._2 != d2._2 || d1._1 <= d2._1))

    } yield (d1._1, d2._1, d3._1)


    val result = sol.size

}
