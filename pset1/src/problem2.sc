// Write and test a function that returns the maximum of two numbers.

import scala.io.StdIn._
import helpers.get._

object problem2{
  def main(args: Array[String]): Unit = {
    // user input
    val num1: Int = integer("Select a number (1 of 2): ");
    val num2: Int = integer("Select another number (2 of 2): ");

    println(max(num1, num2));
  }

  def max(x: Int, y: Int): Int = {
    if (x > y) x else y; 
  }
}