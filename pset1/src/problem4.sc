// Write and test a function for checking the speed of automobile drivers. This function should have one parameter: speed.
// If speed is less than 55, it should print “Ok”.
// Otherwise, for every 5 above the speed limit (55), it should give the driver one demerit point and print the total number of demerit points. For example, if the speed is 80, it should print: “Points: 5”.
// If the driver gets more than 12 points, the function should print: “License suspended”
// Test with speeds of 60, 90, 119 and 120

import scala.io.StdIn._
import helpers.get._

object problem4 {
  def main(args: Array[String]): Unit = {
    val speed: Int = integer("Please enter your speed: ");

    println(speedLimit(speed));
  }

  def speedLimit(speed: Int): String = {
    if(speed < 55){
      return "OK";
    }

    val points = (speed - 55) / 5;

    if (points > 12){
      return "License suspended";
    } else {
      return s"Points: $points";
    }
    
  }
}