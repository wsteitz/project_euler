package euler


abstract class Euler {

    def timingToString(t: Long) =
        t / 1e6 + "ms"

    // used to time functions
    def time(fun: => Unit) = {
        val t0 = System.nanoTime
        fun
        timingToString(System.nanoTime - t0)
    }

    // used to track the overall time
    val startTime = System.nanoTime

    def result :Any

    def main(args: Array[String]) {
        println("result\t" + result)
        println("time\t" + timingToString(System.nanoTime - startTime))

    }
}
