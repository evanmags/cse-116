//
// Copy/paste problem here
//

import scala.io.StdIn._ // import all standard inputs
import scala.collection.immutable.Map
import scala.collection.mutable.ArrayBuffer
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
    println(s"there are ${distinct(testMap)} distinct values in the test map.")
  }

  def distinct(map: Map[String, Int]): Int = {
    val arr: ArrayBuffer[Int] = ArrayBuffer()

    for(n <- map.values){
      if(!arr.contains(n)) arr += n
    }

    arr.length
  }
}
