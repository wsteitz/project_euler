
def pentagonal(n: Int) = n * (3 * n - 1) / 2

val ps = (1 to 10000).map(pentagonal).toSet

val res = (for {
    a <- ps
    b <- ps
    if a < b &&
       ps.contains(a + b) &&
       ps.contains(b - a)
      } yield b - a).min

println(res)
