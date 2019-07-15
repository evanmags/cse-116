//
// Copy/paste problem here
//

import java.util.Calendar 
import scala.io.StdIn._ // import all standard inputs
import helpers.get._ // import helpers, get user input functions

object problem8 { // Change to correct number
  def main(args: Array[String]): Unit = {
    val date: Calendar = Calendar.getInstance()

    val year: Int = integer("Input a year: ")
    val month: Int = integer("Input a month[1-12]: ") - 1 // adjust to 0 indexed months
    val day: Int = integer("Input a day[1-31]: ")

    date.set(year, month, day)

    println(s"Selected date: ${date.get(Calendar.YEAR)}-${date.get(Calendar.MONTH)+1}-${date.get(Calendar.DATE)}")

    date.add(Calendar.DATE, 1)

    println(s"The next date is: ${date.get(Calendar.YEAR)}-${date.get(Calendar.MONTH)+1}-${date.get(Calendar.DATE)}")
  }
}