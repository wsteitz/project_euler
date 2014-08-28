
package euler


object Euler059 extends Euler {

    val input = scala.io.Source.fromFile("data/p059_cipher.txt")
    val text = input.getLines.flatMap(_.split(",").map(_.toInt)).toList

    def decode(text: List[Int], pass: List[Int]) =
        (text zip (Stream continually pass).flatten).map(t => t._1 ^ t._2)

    def toString(ascii: List[Int]) = ascii.map(_.toChar).mkString

    def freqFit(text: List[Int], pass: List[Int]) = {
        val encoded = decode(text, pass)
        val grouped = encoded.map(_.toChar).groupBy(identity)
                .mapValues(_.size.toDouble / text.size)

        grouped.map(t => math.abs(freq(t._1) - t._2)).sum
    }

    // taken from http://en.wikipedia.org/wiki/Letter_frequency
    val freq = Map(('a', 0.08167), ('b',  0.01492), ('c',  0.02782),
                   ('d',  0.04253), ('e',  0.012702), ('f',  0.02228),
                   ('g',  0.02015), ('h',  0.06094), ('i',  0.06966),
                   ('j',  0.00153), ('k',  0.00772), ('l',  0.04025),
                   ('m',  0.02406), ('n',  0.06749), ('o',  0.07507),
                   ('p',  0.01929), ('q',  0.00095), ('r',  0.05987),
                   ('s',  0.06327), ('t',  0.09056), ('u',  0.02758),
                   ('v',  0.00978), ('w',  0.02360), ('x',  0.00150),
                   ('y',  0.01974), ('z',  0.00074)).withDefaultValue(0.0)

    val candidates = for {
        code1 <- 97 to 122
        code2 <- 97 to 122
        code3 <- 97 to 122
        if code1 != code2 && code1 != code3 &&  code2 != code3
    } yield List(code1, code2, code3)

    val best_fit = candidates.map(c => (c, freqFit(text, c))).minBy(_._2)

    val result = decode(text, best_fit._1).sum

}
