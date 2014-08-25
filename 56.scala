
package euler


object Euler056 extends Euler {

    def digitSum(i: BigInt) = i.toString.map(_.asDigit).sum

    val result = (
        for {
            a <- 1 to 99
            b <- 1 to 99
            } yield digitSum(BigInt(a).pow(b)))
        .max

}
