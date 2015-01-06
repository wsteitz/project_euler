
//01, 04, 09, 16, 25, 36, 49, 64, 81

package euler


object Euler090 extends Euler {


    val numbers = 0 to 9

    val results = for {

        c1 <- (0 to 9).combinations(6)
        c2 <- (0 to 9).combinations(6)


        if (c1.contains(0) && c2.contains(1) || c2.contains(0) && c1.contains(1)) &&
           (c1.contains(0) && c2.contains(4) || c2.contains(0) && c1.contains(4)) &&
           (c1.contains(0) && (c2.contains(9) || c2.contains(6)) || c2.contains(0) && (c1.contains(9) || c1.contains(6))) &&
           (c1.contains(1) && (c2.contains(6) || c2.contains(9)) || c2.contains(1) && (c1.contains(6) || c1.contains(9))) &&
           (c1.contains(2) && c2.contains(5) || c2.contains(2) && c1.contains(5)) &&
           (c1.contains(3) && (c2.contains(6) || c2.contains(9)) || c2.contains(3) && (c1.contains(6) || c1.contains(9))) &&
           (c1.contains(4) && (c2.contains(6) || c2.contains(9)) || c2.contains(4) && (c1.contains(9) || c1.contains(6))) &&
           ((c1.contains(6) || c1.contains(9)) && c2.contains(4) || (c2.contains(6) || c2.contains(9)) && c1.contains(4)) &&
           (c1.contains(8) && c2.contains(1) || c2.contains(8) && c1.contains(1))
    } yield (c1, c2)


    val result = results.size / 2

}
