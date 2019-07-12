//
// Write and test a function that uses a while loop to allow entry of some test scores. The while 
// loop should continue until the user enters 'done' instead of a score. After the while loop is 
// completed, the program should print out the total score, and the average score.
//

import scala.io.StdIn._ // import all standard inputs
import scala.collection.mutable.ArrayBuffer
import helpers.get._ // import helpers, get user input functions

object problem10 {
  def main(args: Array[String]): Unit = {
    val scores: List[Float] = floatList("Please enter a score, or 'done': ", "done");

    println(s"Your total score is: ${sum(scores)}")
    println(s"Your average score is: ${average(scores)}")
  }

  def average(l: List[Float]): Float = {
    val total: Float = sum(l);

    if(l.length > 0) total / l.length else 0;
  }

  def sum(l: List[Float]): Float = {
    var sum: Float = 0;

    for (n <- l){
      sum += n
    }

    return sum
  }
}