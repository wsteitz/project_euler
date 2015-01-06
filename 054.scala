package euler


case class Hand(cards: List[String]) {

    def beats(other: Hand) =
        if (rank._1 == other.rank._1)
            if (rank._2 == other.rank._2) rank._3 > other.rank._3
            else rank._2 > other.rank._2
        else rank._1 > other.rank._1

    val suits = cards.map(_.substring(0, 1))
    val values = cards.map(_.head).map {
                  case 'T' => 10
                  case 'J' => 11
                  case 'Q' => 12
                  case 'K' => 13
                  case 'A' => 14
                  case n => n.asDigit}

    val sameSuit = suits.forall(_ == suits.head)
    val straight = values.max - values.min == 4 &&
        (values.min to values.max).forall(values.contains(_))
    val sameCounts = values.groupBy(identity).mapValues(_.size)
    val counts = sameCounts.toList.groupBy(_._2)
                           .mapValues(_.map(t => t._1))
                           .withDefaultValue(Nil)
    def isPair = sameCounts.values.toSet.contains(2)
    def isTripple = sameCounts.values.toSet.contains(3)

    def cardValues(cards: List[Int]) =
        cards.sorted.zipWithIndex.map(t => t._1 * math.pow(10, t._2).toInt).sum

    val rank = {
        // royal flush
        if (sameSuit && straight && values.contains(14)) (9, 14, 0)
        // straight flush
        else if (sameSuit && straight) (8, values.max, 0)
        // four of a kind
        else if (sameCounts.values.max == 4) (7, counts(4).head, counts(1).head)
        // full house
        else if (isPair && isTripple) (6, cardValues(List(counts(3).head, counts(2).head)), 0)
        // flush
        else if (sameSuit) (5, 0, cardValues(counts(1)))
        // straight
        else if (straight) (4, values.max, 0)
        else if (isTripple) (3, counts(3).head, cardValues(counts(1)))
        // two pairs
        else if (sameCounts.size == 3 && isPair)
                (2, cardValues(counts(2)), counts(1).head)
        else if (isPair) (1, counts(2).head, cardValues(counts(1)))
        else (0, 0, cardValues(counts(1)))
    }
}

object Euler054 extends Euler {

   def input = scala.io.Source.fromFile("data/p054_poker.txt")
   val hands = input.getLines.map(_.split(" ")
                                   .toList
                                   .grouped(5)
                                   .toList)
                             .map(l => (Hand(l(0)), Hand(l(1))))
                             .toList

   val result = hands.count(h => h._1.beats(h._2))
}
