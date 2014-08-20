
def cycleLength(num: Double, den: Int, r: List[Double]): Int = {
    val rem = num % den
    val ind = r.indexOf(rem)
    if (ind != -1) r.size - ind
    else cycleLength(rem * 10, den, r :+ rem)
}

val sol = (1 to 1000).map(n => (n, cycleLength(1.0, n, List())))
           .sortBy(_._2).reverse.head

println(sol)
