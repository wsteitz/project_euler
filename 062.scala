
package euler


object Euler062 extends Euler{

    val cubes = (2 to 50000).map(BigInt(_))
                            .map(n => (n, (n * n * n).toString.sorted))

    val smallest = cubes.groupBy(_._2).values.map(v => (v.min, v.size))
                        .filter(_._2 == 5).min._1._1

    val result = smallest * smallest * smallest
}
