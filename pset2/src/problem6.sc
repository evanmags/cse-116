//
// Copy/paste problem here
//

import scala.io.StdIn._ // import all standard inputs
import helpers.get._ // import helpers, get user input functions

object problem6 { // Change to correct object name
  def main(args: Array[String]): Unit = {
    val limit: Int = integer("Please enter an integer limit: ")

    println(s"The average of all numbers from 1 to $limit is: ${averageList(limit)}")
  }

  def averageList(limit: Int): Float = {
    var total: Float = 0;

    for (n <- 1 to limit){
      total += n;
    }
    println(total)
    total / limit
  }
}