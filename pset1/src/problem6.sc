// Write and test a function that returns the sum of multiples of 3 and 5 between 0 and limit (parameter). For example, if limit is 20, it should return the sum of 3, 5, 6, 9, 10, 12, 15, 18, 20.
//    	Test with 20, 28 and 96

import scala.io.StdIn._
import helpers.get._

object problem6 {
  def main(args: Array[String]): Unit = {
    val limit: Int = integer("Please enter an integer limit: ");

    println(sumOfMultiples(limit));
  }

  def sumOfMultiples(limit: Int): Int = {
    var sum: Int = 0;

    for (i <- 1 to limit){
      if (i % 3 == 0 || i % 5 == 0){
        sum += i;
      }
    }

    return sum;
  }
}