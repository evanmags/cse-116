//
// Write and test a function that accepts a string as an argument and prints out whether this 
// string is a palindrome or not. 
// A palindrome is a string that reads the same forwards and backwards. In testing your string you 
// should ignore blanks, punctuation and case differences (be case-insensitive). Be sure that you 
// test multi-word strings such as (“Sit on a potato pan, Otis.”)
//

import scala.io.StdIn._ // import all standard inputs

object problem1 {
  def main(args: Array[String]): Unit = {
    val phrase: String = readLine("Please enter a string: ")

    val not: String = if(isPalindrome(phrase)) "" else " NOT"

    println(s"'$phrase' is$not a palindrome")
  }

  def isPalindrome(test: String): Boolean = {
    val stripped: String = test.replaceAll("[^a-zA-Z]", "").toLowerCase()
    val reversed: String = stripped.reverse
    
    stripped == reversed
  }
}