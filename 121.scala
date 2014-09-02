
package euler


object Euler121 extends Euler {

    def chance(events: List[Boolean]) =
        events.zipWithIndex
              .map(t => (t._1, t._2 + 1))
              .map(t => if (t._1) 1 / (1.0 + t._2) else t._2 / (1.0 + t._2))
              .product


    def chanceOfLoss(rounds: Int) = {
        val goal = rounds / 2 + 1
      (for {
        g <- goal to rounds
        r = rounds - g
        play = (List.fill(g)(true) ++ List.fill(r)(false))
        perm <- play.permutations
        }  yield chance(perm)).sum
    }

    val result = (1 / chanceOfLoss(15)).toInt
}
