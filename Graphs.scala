package euler



object Graphs {


  type Path[T] = (Int, List[T])

  case class Edge[T](a: T, b: T, w: Int)


  def dijkstra[T](edges: Seq[Edge[T]], origin: T, dest: T) = {

      val adj = edges groupBy(_.a) mapValues(_ map(e => (e.w, e.b)))

      def rec(fringe: Seq[Path[T]], visited: Set[T]): Path[T] = fringe match {
        case Nil => (0, List())
        case (dist, path) :: fringe_rest =>
            path match {
                case Nil => (0, List())
                case key :: path_rest =>
                  if (key == dest) (dist, path.reverse)
                  else {
                    val paths = adj(key) flatMap {case (d, key) => if (!visited.contains(key)) List((dist + d, key :: path)) else Nil}
                    val sorted_fringe = (paths ++ fringe_rest).sortWith {case ((d1, _), (d2, _)) => d1 < d2}
                    rec(sorted_fringe, visited + key)
                  }
        }

      }
    rec(List((0, List(origin))), Set())
    }

}


