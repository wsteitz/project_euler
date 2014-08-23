package euler

object Euler112 extends Euler{

    def isBouncy(n: Int): Boolean = {
        val s = n.toString
        s != s.sorted && s != s.sorted.reverse
    }

    def check(n: Int, count: Int): Unit = {
        if ((count.toDouble / n) >= 0.99) println(n)
        else check(n + 1, count + (if (isBouncy(n + 1)) 1 else 0))
    }

    val result = check(1, 0)
}
