
package euler


object Euler079 extends Euler {


    val input = scala.io.Source.fromFile("data/p079_keylog.txt")
    val attempts = input.getLines.map(_.map(c => c.asDigit).toList).toList
    val digits = attempts.flatten.distinct

    def swap[A](l: List[A], x: Int) = {
      val (l1,rest) = l.splitAt(x)
      val (l2,l3) = rest.splitAt(rest.length-x)
      l3 ::: l2 ::: l1
    }

    def sort(pass: List[Int], input: List[Int]): List[Int] =
        input match {
            case Nil => pass
            case a :: b :: r => {
                val ind_a = pass.indexOf(a)
                val ind_b = pass.indexOf(b)
                if (ind_b < ind_a) sort(pass.updated(ind_b, a).updated(ind_a, b), b :: r)
                else sort(pass, b :: r)
            }
            case a :: as => pass
        }

    val result = attempts.foldLeft(digits)((pass, attempt) => sort(pass, attempt)).mkString

}
