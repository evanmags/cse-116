//
// Copy/paste problem here
//

import java.util.Calendar
import scala.io.StdIn._ // import all standard inputs
import helpers.get._ // import helpers, get user input functions

object problem8 { // Change to correct number
  def main(args: Array[String]): Unit = {
    val now: Calendar = Calendar.getInstance()

    val year: Int = integer("Input a year: ")
    val month: Int = integer("Input a month[1-12]: ") - 1
    val date: Int = integer("Input a day[1-31]: ")

    now.set(year, month, date)

    println(s"Selected date: ${now.get(Calendar.YEAR)}-${now.get(Calendar.MONTH)+1}-${now.get(Calendar.DATE)}")

    now.add(Calendar.DATE, 1)

    println(s"The next date is: ${now.get(Calendar.YEAR)}-${now.get(Calendar.MONTH)+1}-${now.get(Calendar.DATE)}")
  }
}