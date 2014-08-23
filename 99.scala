package euler

object Euler099 extends Euler {


    val input = scala.io.Source.fromFile("data/p099_base_exp.txt")

    val res = input.getLines
                   .map(_.split(",")
                         .map(_.toInt))
                   .map(l => l.tail.head * math.log(l.head))
                   .zipWithIndex
                   .max

    val result = res._2 + 1

}
