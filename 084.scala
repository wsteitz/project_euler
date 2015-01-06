
package euler


case class CardStack(cards_raw: Vector[String]) {
    var index = 0
    val cards = scala.util.Random.shuffle(cards_raw)

    def next = {
      index = (index + 1) % cards.size
      cards(index)
    }
  }


case class Monopoly() {

    var pos = "go"
    var doubles = 0

    val fields = Vector("go", "a1", "cc1", "a2", "t1", "r1", "b1", "ch1", "b2", "b3",
                        "jail", "c1", "u1", "c2", "c3", "r2", "d1", "cc2", "d2",
                        "d3", "fp", "e1", "ch2", "e2", "e3", "r3", "f1", "f2",
                        "u2", "f3", "g2j", "g1", "g2", "cc3", "g3", "r4", "ch3",
                        "h1", "t2", "h2")

    val fieldToNum = fields.zipWithIndex.toMap

    val sides = 4

    def rolldice = (scala.util.Random.nextInt(sides) + 1,
                    scala.util.Random.nextInt(sides) + 1)

    def move(pos: String, moves: Int) = fields((fieldToNum(pos) + moves) % fields.size)

    def community_cards = CardStack(Vector.fill(14)("") :+ "go" :+ "jail")

    def communityChest(pos: String) = {
        val card = community_cards.next
        card match {
            case "" => pos
            case _ => card
        }
    }

    def nextRailway(pos: String) = {
        val num = fieldToNum(pos)
        if (num < 5) "r1"
        else if (num < 15) "r2"
        else if (num < 25) "r3"
        else if (num < 35) "r3"
        else "r1"
    }

    def nextUtility(pos: String) = {
        val num = fieldToNum(pos)
        if (num < 12) "u1"
        else if (num < 28) "u2"
        else "u1"
    }

    def chance_cards = CardStack(Vector.fill(6)("") ++ Vector("go", "jail", "c1", "e3", "h2",
                                                        "r1", "r", "r", "u", "minus"))


    def handleMinus(pos: String) = {
        val next = fields(fieldToNum(pos) - 3)
        if (next.startsWith("cc")) communityChest(next) else (next)
    }

    def chanceField(pos: String) = {
        val card = chance_cards.next
        card match {
            case "r" => nextRailway(pos)
            case "u" => nextUtility(pos)
            case "minus" => handleMinus(pos)
            case "" => pos
            case _ => card
        }
    }

    def nextField(moves: Int) = {
        val next = move(pos, moves)
        if (doubles >= 3) {
            doubles = 0
            "jail"
        }
        if (next.startsWith("cc")) communityChest(next)
        else if (next.startsWith("ch")) chanceField(next)
        else if (next == "g2j") "jail"
        else next
    }

    def step() = {
        val d = rolldice
        doubles = if (d._1 == d._2) doubles + 1 else 0
        pos = nextField(d._1 + d._2)
        pos
    }
}


object Euler084 extends Euler {
    // just simulate

    val n = 1000000
    val m = Monopoly()
    val result = (for(i <- 1 to n) yield m.step)
                .groupBy(identity)
                .mapValues(_.size)
                .toList.sortBy(_._2).reverse
                .take(3)
                .map(t => m.fieldToNum(t._1))
                .mkString
}
