package euler

object Euler205 extends Euler {


    val peter = for {
        a <- 1 to 4
        b <- 1 to 4
        c <- 1 to 4
        d <- 1 to 4
        e <- 1 to 4
        f <- 1 to 4
        g <- 1 to 4
        h <- 1 to 4
        i <- 1 to 4
        } yield a + b + c + d + e + f + g + h + i

    val colin = for {
        a <- 1 to 6
        b <- 1 to 6
        c <- 1 to 6
        d <- 1 to 6
        e <- 1 to 6
        f <- 1 to 6
        } yield a + b + c + d + e + f

    val petergrp = peter.groupBy(identity).map{case (key, values) => (key, values.size.toLong)}
    val colingrp = colin.groupBy(identity).map{case (key, values) => (key, values.size.toLong)}

    val different_games = peter.size.toLong * colin.size
    val peter_wins = petergrp.map{case (p, p_count) =>
        p_count * colingrp.filter{case (c, c_count) => p > c}.map{case (c, c_count) => c_count}.sum}.sum

    val result = "0" + (Math.round(10000000.0 * peter_wins / different_games).toInt).toString
}
