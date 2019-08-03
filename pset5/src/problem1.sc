//
// Copy/paste problem here
//

import scala.io.StdIn._ // import all standard inputs
import helpers.get._ // import helpers, get user input functions
import scala.io._
import scala.collection.mutable.ListBuffer
import java.io._

object problem1 {
  def main (args: Array[String]): Unit = {
    // open file and read in ALL names to an array of tuples
    val file: BufferedSource = Source.fromFile(args(0))
    val unsorted: ListBuffer[(String, String)] = ListBuffer()
    for (line <- file.getLines()){
      val split: Array[String] = line.split(" ")
      unsorted += Tuple2(split(1), split(0))
    }
    file.close

    val sorted: List[(String, String)] = mergeSort(unsorted.toList)

    val out: PrintWriter = new PrintWriter(new FileWriter("../src/result.txt"))
    for((last, first) <- sorted){
      out.write(s"$last, $first\n")
    }
    out.close

    // (last, first)
    // run a quick sort on all last names
  }

  def mergeSort(l: List[(String, String)]): List[(String, String)] = {
    if(l.length == 1) return l;
    else {
      val left: List[(String, String)] = mergeSort(l.slice(0, l.length / 2))
      val right: List[(String, String)] = mergeSort(l.slice(l.length / 2, l.length))
      merge(ListBuffer(left: _*), ListBuffer(right: _*))
    }
  }

  def merge(left: ListBuffer[(String, String)], right: ListBuffer[(String, String)]): List[(String, String)] = {
    val merged: ListBuffer[(String, String)] = ListBuffer()
    while (left.length > 0 && right.length > 0) {
      if (left(0)._1.length < right(0)._1.length){
        merged += left.remove(0)
      } 
      else if(left(0)._1.length == right(0)._1.length){
        if(left(0)._2.length > right(0)._2.length){
          merged += left.remove(0)
        } else {
          merged += right.remove(0)
        }
      }
      else {
        merged += right.remove(0)
      }
    }

    left.foreach( merged += _ )
    right.foreach( merged += _ )

    merged.toList
  }
}