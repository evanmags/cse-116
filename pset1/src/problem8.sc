// Write and test a function named sort that accepts 3 numeric arguments and prints the 3 numbers in numeric order. Ex: sort(27, 66, 9) prints 9, 27, 66
// Test with all six possible orders;
// 	1,  2,  3
// 	1,  3,  2
// 	2,  1,  3
// 	2,  3,  1
// 	3,  1,  2
// 	3,  2,  1

import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer
import helpers.get._

object problem9 {
  def main (args: Array[String]): Unit = {
    val num1: Int = integer("Please enter an integer (1 of 3): ");
    val num2: Int = integer("Please enter an integer (2 of 3): ");
    val num3: Int = integer("Please enter an integer (3 of 3): ");

    printSorted(num1, num2, num3);
  }

  def printSorted(a: Int, b: Int, c: Int): Unit = {
    val unsorted: ArrayBuffer[Int] = ArrayBuffer(a, b, c);
    
    while (unsorted.length > 0){
      var smallest: Int = unsorted(0);

      for (x <- unsorted){
        if (x < smallest){
          smallest = x;
        }
      }

      print(smallest)
      if (unsorted.length > 1){
        print(", ")
      }

      unsorted -= smallest;
    }

    println()
  }
}