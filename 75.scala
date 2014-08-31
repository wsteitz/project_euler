
package euler

import Tools.gcd


object Euler075 extends Euler {


    val limit = math.sqrt(1500000 / 2).toInt

    // create pythagorean triples, calc perimeter, count
    val result = (for {
            v <- 1 to limit
            u <- v + 1 to limit if gcd(u, v) == 1 && (u + v) % 2 == 1
            x = u * u - v * v
            y = 2 * u * v
            z = u * u + v * v
            perimeter = x + y + z
            k <- 1 to 1500000 / perimeter
            if k * perimeter <= 1500000
            } yield perimeter * k)
            .groupBy(identity).values.count(_.size == 1)
}

