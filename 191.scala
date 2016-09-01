package euler

import Tools.binomialCoefficient


object Euler191 extends Euler {

  // A no L ending with A
  // B one L ending with A
  // C no L ending with AA
  // D one L ending with AA
  // E no L ending with O
  // F one L ending with O or L
  
  val solution3 = (2, 3, 1, 1, 4, 8)
  
  // next day .. 
  // A => E
  // B => F
  // C => A
  // D => B
  // E => A + C + E
  // F => A + B + C + D + E + F
  
  def numPrize(d: Int): (Int, Int, Int, Int, Int, Int) =
    if (d == 3) solution3
    else {
      numPrize(d - 1) match {
        case (a, b, c, d, e, f) => (e, f, a, b, a + c + e, a + b + c + d + e + f)  
      }
    }
    
  def count(t: (Int, Int, Int, Int, Int, Int)): Int = 
    t match {
     case (a, b, c, d, e, f) => a + b + c + d + e + f
  }
   
  val result = count(numPrize(30))
    
}
