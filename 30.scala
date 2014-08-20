

val power = 5


val res = for {
      n <- 2 to 1000000
      if n.toString.map(d => math.pow(d.asDigit, power).toInt).sum == n
    } yield n


println(res.sum)
