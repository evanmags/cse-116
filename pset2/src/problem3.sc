//
// Write and test a function that accepts a string argument. This will be a long string containing 
// multiple words. Print the string but with the words (not the characters) reversed. For example,
// the string “My name is jim” would be printed back as “jim is name my”  (not as “mij si eman yM”)
//

import scala.io.StdIn._ // import all standard inputs
import helpers.get._ // import helpers, get user input functions

object problem3 {
  def main(args: Array[String]): Unit = {
    val string: String = readLine("Please enter a string: ");

    println(reverseWords(string))
  }

  def reverseWords(str: String): String = {
    val arr: Array[String] = str.split(" ");
    var resString: String = "";

    for (n <- 0 until arr.length){
      var i: Int = (arr.length - 1) - n;
      resString += s"${arr(i)} ";
    }

    return resString;
  }
}