package euler


abstract class Euler {

    def timingToString(t: Long) = {
        val td = t / 1e6
        if (td < 1000) td + "ms"
        else td / 1000 + "s"
    }

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
        println("time\t" + timingToString(System.nanoTime - startTime))
        println("result\t" + result)
    }
}
