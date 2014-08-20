
val ns = 2 to 100

val res = (for {
                a <- ns
                b <- ns
            } yield BigInt(a).pow(b)).distinct.sorted

println(res.size)
