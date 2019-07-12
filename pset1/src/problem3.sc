// Write and test a function called summer_winter that takes a number.
//  If the number is divisible by 3, it should return “Summer”.
//  If it is divisible by 5, it should return “Winter”.
//  If it is divisible by both 3 and 5, it should return “SummerWinter”.
//  Otherwise, it should return the original number.
// Test with numbers, 15, 33, 97 and 100

import scala.io.StdIn._
import helpers.get._

object problem3{
  def main(args: Array[String]): Unit = {
    val num: Int = integer("Please enter a number: ");

    println(summer_winter(num));
  }

  def summer_winter(x: Int): String = {
    var result: String = "";

    if (x % 3 == 0) result += "Summer";
    if (x % 5 == 0) result += "Winter";

    if (result != "") result else x.toString;
  }

}