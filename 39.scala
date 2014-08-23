
package euler

object Euler039 {

    val result = (for {
            perimeter <- 120 to 1000
            a <- 1 to perimeter / 3
            b <- a to (perimeter - 2 * a)
            c = perimeter - a - b
            if a * a + b * b == c * c
            } yield perimeter)
            .groupBy(identity)
            .mapValues(_.size)
            .maxBy(_._2)
}
