//
// Write and test a function that accepts a numeric argument (a limit) and prints all the Fibonacci 
// numbers less than or equal to this limit. The Fibonacci sequence is a sequence of numbers where 
// the next number in the sequence is the sum of the previous two numbers in the sequence. The 
// sequence looks like this: 1, 1, 2, 3, 5, 8, 13, … (it should not start with 0).
//

import scala.io.StdIn._ // import all standard inputs
import helpers.get._ // import helpers, get user input functions

object problem2 {
  def main(args: Array[String]): Unit = {
    val limit: Int = integer("Please enter an integer limit: ");
    
    printFibonacci(limit);
  }

  def printFibonacci(limit: Int): Unit = {
    var cur: Int = 1;
    var last: Int = 1;

    print(s"$last");

    while (cur <= limit){
      print(s", $cur");

      val temp: Int = cur;
      cur += last;
      last = temp;
    }

    println();
  }
}