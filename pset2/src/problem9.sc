//
// Copy/paste problem here
//

import scala.io.StdIn._ // import all standard inputs
import scala.collection.immutable.Map
import helpers.get._ // import helpers, get user input functions

object problem9 { // Change to correct object name
  def main(args: Array[String]): Unit = {
    val testMap: Map[String, Int] = Map(
      "one" -> 1,
      "two" -> 2,
      "three" -> 1,
      "four" -> 3,
      "five" -> 2,
    )

    val value: Int = integer("Please enter an integer value to search for: ")

    println(s"the value $value, appears in the test map ${search(testMap, value)} time(s).")
  }

  def search(map: Map[String, Int], value: Int): Int = {
    map.values.count((v) => v == value)
  }
}
