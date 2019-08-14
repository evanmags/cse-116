//
// Copy/paste problem here
//

import scala.io.StdIn._ // import all standard inputs
import helpers.get._ // import helpers, get user input functions
import scala.util.Random
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer
import scala.math.pow
import java.util.Calendar

class SortingThread(items: Int) extends Runnable {
  val rnd: Random = new Random()
  val lst: ArrayBuffer[Int] = ArrayBuffer({for (n <- 0 to items) yield rnd.nextInt(1000000)}: _*)
  override def run: Unit = { 
    val time1 = System.nanoTime()
    bubbleSort(lst)
    val time2 = System.nanoTime()
    print((time2 - time1)/pow(10, 11))
    println(s" seconds to sort 1, $items element list")
  }

  def bubbleSort(l: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    for(i <- 0 until l.length){
      var num = l.remove(0);
      for (j <- 0 until l.length - i){
        if (num > l(j)){
          l.insert(j, num)
          num = l.remove(j + 1)
        }
      }
      l.append(num)
    }
    return l
  }
}

object problemX {
  def main (args: Array[String]): Unit = {
    val t1 = new Thread(new SortingThread(7500))
    val t2 = new Thread(new SortingThread(7500))
    val t3 = new Thread(new SortingThread(7500))
    val t4 = new Thread(new SortingThread(7500))
    println("done creating lists")

    t1.start()
    t2.start()
    t3.start()
    t4.start()
    print("started")

    t1.join()
    t2.join()
    t3.join()
    t4.join()
    print("joined")

    val t5 = new Thread(new SortingThread(10))
    println("done creating list")

    t5.start()

    t5.join()

  }
}