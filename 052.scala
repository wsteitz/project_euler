package euler


object Euler052 extends Euler {

    def sameDigits(a: Int, b: Int) = a.toString.sorted == b.toString.sorted

    val range = (1 to 6)
    def permutedMultiple(n: Int) = range.forall(i => sameDigits(n, n * i))

    val result = Stream.from(1).find(permutedMultiple).get

}
