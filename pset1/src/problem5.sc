// Write and test a function called oddEven that takes a parameter called limit. It should print all the numbers between 0 and limit with a label to identify the even and odd numbers. For example, if the limit is 3, it should print:
// 0 EVEN
// 1 ODD
// 2 EVEN
// 3 ODD
// Test with the number 7.

import scala.io.StdIn._
import helpers.get._

object problem5 {
  def main (args: Array[String]): Unit = {
    val limit: Int = integer("Please enter an integer limit: ");

    oddEven(limit);
  }
  
  def oddEven(limit: Int): Unit = {
    for(i <- 0 to limit){
      print(i);
      println(if(i % 2 == 0) " EVEN" else " ODD");
    }
  }
}