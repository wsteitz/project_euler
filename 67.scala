import scala.io.Source

val data = Source.fromFile("p067_triangle.txt").getLines.map(_.split(" ").map(_.toInt).toList).toList.reverse


def doit(d: List[List[Int]], acc: List[Int]): Int = {
    if (d.head.size == 1)
        d.head.head + acc.head
    else 
        doit(d.tail, d.head.zip(acc).map(t => t._1 + t._2).sliding(2).toList.map(_.max))
}


val res = doit(data, List.fill(data.size)(0))
println(res)
