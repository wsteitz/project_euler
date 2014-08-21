
val input = scala.io.Source.fromFile("p099_base_exp.txt")

val res = input.getLines
               .map(_.split(",")
                     .map(_.toInt))
               .map(l => l.tail.head * math.log(l.head))
               .zipWithIndex
               .max

println(res._2 + 1)
