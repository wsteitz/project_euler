
package euler

object Euler125 extends Euler{

    def isPalindrom(s: String): Boolean = s == s.reverse
    val n = 100000000

    def foo(current: Int, acc:BigInt, len:Int): List[BigInt] = {
        if (acc > n) Nil
        else if (isPalindrom(acc.toString) && len > 1) {
            acc :: foo(current + 1, acc + current * current, len + 1) }
            else foo(current + 1, acc + current * current,  len + 1)
    }

    val res = (1 to math.sqrt(n).toInt).flatMap(n => foo(n, 0, 0)).toList.distinct

    val result = res.sum

}
