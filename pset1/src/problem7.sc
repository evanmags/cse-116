// Write and test a function that takes a numeric argument and returns true if the argument is a prime number (and false if not).
// Test with 7, 49 and 97.

import scala.io.StdIn._
import helpers.get._

object problem7 {
  def main (args: Array[String]): Unit = {
    val number: Int = integer("Enter an integer to check if it is prime: ");

    println(isPrime(number));
  }

  def isPrime(num: Int): Boolean = {
    for (divisor <- 2 until (num / 2)){
      if (num % divisor == 0) return false;
    }
    return true;
  }
}
