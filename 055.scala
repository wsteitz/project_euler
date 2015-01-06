package euler

object Euler055 extends Euler {


    def isPalindrom(s: String): Boolean = (s.size >= 2) && s == s.reverse

    def isLychrei(n: BigInt, rec: Int): Boolean = {

        if (rec > 0 && isPalindrom(n.toString))
          return false

        if (rec > 50) {
          return true
        }

        return isLychrei(n + BigInt(n.toString.reverse), rec + 1)
    }

    val result = (Range(1, 10000).filter(isLychrei(_, 0)).size)


}
