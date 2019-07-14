//
// Copy/paste problem here
//

import scala.io.StdIn._ // import all standard inputs
import scala.util.matching.Regex
import helpers.get._ // import helpers, get user input functions

object problem5 { // Change to correct object name
  def main(args: Array[String]): Unit = {
    val password: String = readLine("Please enter your password: ")
    val not: String = if(testPassword(password)) "" else " NOT"

    println(s"$password is$not a secure password")
  }

  def testPassword(pass: String): Boolean = {
    val regex: Regex = "^((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[$#@])(.{6,16}))$".r
    pass match {
      case regex(_*) => true
      case _ => false
    }
  }
}