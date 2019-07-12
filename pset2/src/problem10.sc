//
// Copy/paste problem here
//

import scala.io.StdIn._ // import all standard inputs
import scala.collection.immutable.Vector
import scala.collection.mutable.Map
import helpers.get._ // import helpers, get user input functions

object problem10 { // Change to correct object name
  def main(args: Array[String]): Unit = {
    val vec1: Vector[Int] = Vector(2, 4, 3, 0, 0, 0, 9, 7, 8)
    val vec2: Vector[Int] = Vector(0, 5, 1, 0, 1, 0, 0, 0, 2)
    
    val spar1: Map[Int, Int] = makeSparse(vec1)
    val spar2: Map[Int, Int] = makeSparse(vec2)

    println(sumSparse(spar1, spar2))
    println(dotSumSparse(spar1, spar2))
  }

  def makeSparse(vec: Vector[Int]): Map[Int, Int] = {
    var sparse: Map[Int, Int] = Map()
    
    for(n <- 0 until vec.length){
      if(vec(n) != 0){
        sparse += (n -> vec(n))
      }
    }

    return sparse
  }

  // needs to handle 
  def sumSparse(vec1: Map[Int, Int], vec2: Map[Int, Int]): Map[Int, Int] = {
    var sum: Map[Int, Int] = Map()
    for (key <- vec1.keys){
      sum += (key -> vec1(key))
    }
    for (key <- vec2.keys){
      if(vec1.get(key) != None){
        sum(key) += vec2(key)
      }
      else sum += (key -> vec2(key))
    }
    return sum
  }

  def dotSumSparse(vec1: Map[Int, Int], vec2: Map[Int, Int]): Int = {
    var dot: Map[Int, Int] = Map()
    for (key <- vec1.keys){
      dot += (key -> vec1(key))
    }
    for (key <- vec2.keys){
      if(vec1.get(key) != None){
        dot(key) *= vec2(key)
      }
      else dot += (key -> vec2(key))
    }
    
    var dotSum: Int = 0
    for (value <- dot.values){
      dotSum += value
    }

    return dotSum
  }
}