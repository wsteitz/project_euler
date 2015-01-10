package euler


object Euler005 extends Euler {

    val divisors = 11 to 20
    val result = Stream.from(1).map(_ * 2520).find(i => divisors.forall(d => i % d == 0)).get
}
