//
// Write and test a function that asks for the names of all the members in a club. However, we 
// don't know how many members are actually in the club. Use a “while-loop” which will simply 
// repeat until all the member's names have been entered. How will you communicate to the program 
// that there are no more names to enter?
//

import scala.io.StdIn._ // import all standard inputs
import helpers.get._ // import helpers, get user input functions

object problem4 { // Change to correct object name
  def main(args: Array[String]): Unit = {
    val names: List[String] = stringList("Please enter a name, or ':qa' to exit: ", ":qa")

    for (name <- names) {
      println(name);
    }
  }
}