
package euler

/*

    6
     \
      7
    /  \   0
   /    \ /
  2      8
 / \    /
1   3--5--9
     \
      4

Simply generate all permutations, filter all valid solutions and
get the max. Since we are searching for a 16-digit solution, 10 has to
to be in an outer position.

*/


object Euler068 extends Euler {

    val solutions = for {
        p <- Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).permutations
        s = p(1) + p(2) + p(7)
        if p(6) + p(7) + p(8) == s &&
           p(3) + p(5) + p(9) == s &&
           p(5) + p(8) + p(0) == s &&
           p(2) != 10 && p(3) != 10 && p(5) != 10 && p(7) != 10 && p(8) != 10 &&
           p(0) < p(9) && p(0) < p(4) && p(0) < p(1) && p(0) < p(6)
    } yield List(p(0), p(8), p(5), p(9), p(5), p(3), p(4), p(3), p(2),
                 p(1), p(2), p(7), p(6), p(7), p(8))

    val result = solutions.map(s => s.map(_.toString).mkString).max

}
