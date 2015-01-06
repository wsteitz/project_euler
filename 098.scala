
package euler


object Euler098 extends Euler {


    val input = scala.io.Source.fromFile("data/p098_words.txt")
    val words = input.getLines.flatMap(_.split(","))
                .map(_.replace("\"", "")).toList

    val anagrams = for {
            w1 <- words
            w2 <- words
            if w1 < w2 && w1.sorted == w2.sorted
        } yield (w1, w2)


    def isSquare(i: Int) = {
        val r = math.sqrt(i).toInt
        r * r == i
    }

    val result = (for {
        (a, b) <- anagrams
        l = a.distinct.size
        comb <- "1234567890".combinations(l)
        mask <- comb.permutations
        sub = a.distinct.zip(mask).toMap
        a_int = a.map(sub(_)).toInt
        b_int = b.map(sub(_)).toInt
        if sub(a.head) != '0' && sub(b.head) != '0' &&
           isSquare(a_int) && isSquare(b_int)
    } yield List(a_int, b_int))
        .flatten.max


}
