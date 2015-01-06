package euler


object Euler061 extends Euler {

    def triangle(n: Int) = n * (n + 1) / 2
    def square(n: Int) = n * n
    def pentagonal(n: Int) = n * (3 * n - 1) / 2
    def hexagonal(n: Int) = n * (2 * n - 1)
    def heptagonal(n: Int) = n * (5 * n - 3) / 2
    def octagonal(n: Int) = n * (3 * n - 2)

    val polygones = List((0, (1 to 10000).map(triangle).filter(_ < 10000).filter(_ > 1000)),
                         (1, (1 to 10000).map(square).filter(_ < 10000).filter(_ > 1000)),
                         (2, (1 to 10000).map(pentagonal).filter(_ < 10000).filter(_ > 1000)),
                         (3, (1 to 10000).map(hexagonal).filter(_ < 10000).filter(_ > 1000)),
                         (4, (1 to 10000).map(heptagonal).filter(_ < 10000).filter(_ > 1000)),
                         (5, (1 to 10000).map(octagonal).filter(_ < 10000).filter(_ > 1000)))
                 .flatMap(p => p._2.map(v => (p._1, v)))

    def fits(a: Int, b: Int) = a != b && a % 100 == b / 100

    val mapped = polygones.map(p =>
        p -> polygones.filter(p2 => p2._1 != p._1 && fits(p._2, p2._2)))
            .filter(_._2.size > 0).toMap.withDefaultValue(Nil)

    val result = (for {
        a <- polygones.filter(_._1 == 0)
        b <- mapped(a)
        c <- mapped(b)
        d <- mapped(c)
        e <- mapped(d)
        f <- mapped(e)
        if fits(f._2, a._2) &&
           List(a._1, b._1, c._1, d._1, e._1, f._1).distinct.size == 6 &&
           List(a._2, b._2, c._2, d._2, e._2, f._2).distinct.size == 6
    } yield a._2 + b._2 + c._2 + d._2 + e._2 + f._2).head

}
