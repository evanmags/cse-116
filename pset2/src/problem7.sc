//
// Copy/paste problem here
//

import scala.io.StdIn._ // import all standard inputs
import helpers.get._ // import helpers, get user input functions

object problem7 { // Change to correct object name
  def main(args: Array[String]): Unit = {
    val limit: Int = integer("Please enter an integer limit: ")

    for (n <- 1 to limit if n % 2 == 0){
      if(isEvenDigits(n)) println(s"$n has only even digits")
    }
  }

  def isEvenDigits(num: Int): Boolean = {
    var mutNum: Int = num 
    while (mutNum > 0){
      var digit: Int = mutNum % 10
    
      if (digit % 2 != 0) return false

      mutNum = (mutNum - digit) / 10
    }

    return true
  }
}