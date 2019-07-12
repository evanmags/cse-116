// Write and test a function that takes the user’s name and age as parameters. Print a message      which addresses the user by name and tells the person the year that they will turn 65 years of age.
// Test with ages 19, 65 and 95
import scala.io.StdIn._
import helpers.get._

object problem1 {
  def main(args: Array[String]): Unit = {
    // get user input
    val name: String = readLine("What is your name? ");
    val age: Int = integer("How old are you? ");
    
    // calculations
    val diffInAge: Int = 65 - age;
    val year: Int = 2019 + diffInAge;
    var tense: String = if (diffInAge > 0) "will" else "did";

    println(s"Hello $name, you $tense turn 65 in $year");
  }
}