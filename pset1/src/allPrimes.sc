// Write and test a function that prints all the prime numbers between 0 and limit where limit is a parameter to the function.
// Test with a limit of 100

import scala.io.StdIn._
import helpers.get._

object allPrimes {
  def main(args: Array[String]): Unit = {
    val limit: Int = integer("Please select an integer limit: ");

    for (num <- 2 to limit){
      if (isPrime(num)){
        println(s"$num is prime");
      }
    }
  }

  def isPrime(num: Int): Boolean = {
    for (divisor <- 2 until (num / 2)){
      if (num % divisor == 0) return false;
    }
    return true;
  }
}
