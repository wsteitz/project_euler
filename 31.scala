
package euler


object Euler031 {
    

    val coins: List[Int] = List(1, 2, 5, 10, 20, 50, 100, 200)


    def split(rest: Int, sol: List[Int]): List[List[Int]] = {
        
        if (rest == 0) List(sol)
        
        else
          coins.flatMap(c => if (c<=rest && (sol.size == 0 || c<=sol.head)) split(rest - c, c +: sol) else Nil)
        
    }



    val res = split(200, List())

    println(res.size)

}
