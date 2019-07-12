//
// Write and test a function that accepts a positive number as the parameter and determines if the 
// number is a “Perfect Number”. A Perfect Number is one whose divisors sum to the number itself. 
// Ex:    28 = 1 + 2 + 4 + 7 + 14
// Test with 28, 272, 496 and 8128.
//

import scala.io.StdIn._ // import all standard inputs
import helpers.get._ // import helpers, get user input functions

object problem9 {
  def main(args: Array[String]): Unit = {
    val test: Int = integer("Please enter a number to test: ");

    val not: String = if(isPerfect(test)) "" else " NOT";

    println(s"$test is$not a perfect number");
  }

  def isPerfect(test: Int): Boolean = {
    var sum: Int = 0;

    for (num <- 1 until test){
      if (test % num == 0){
        sum += num;
      }
    }

    test == sum
  }
}