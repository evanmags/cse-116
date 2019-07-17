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
    
    for(i <- 0 until vec.length){
      if(vec(i) != 0){
        sparse += (i -> vec(i))
      }
    }

    return sparse
  }

  // needs to handle 
  def sumSparse(vec1: Map[Int, Int], vec2: Map[Int, Int]): Map[Int, Int] = {
    var sum: Map[Int, Int] = Map()

    for (vec <- List[Map[Int, Int]](vec1, vec2)){
      for (key <- vec.keys){
        if(sum.get(key) != None){
          sum(key) += vec(key)
        }
        else sum += (key -> vec(key))
      }
    }
    return sum
  }

  def dotSumSparse(vec1: Map[Int, Int], vec2: Map[Int, Int]): Int = {
    var dot: Map[Int, Int] = Map()
    
    for (vec <- List[Map[Int, Int]](vec1, vec2)){
      for (key <- vec.keys){
        if(dot.get(key) != None){
          dot(key) *= vec(key)
        }
        else dot += (key -> vec(key))
      }
    }
    
    dot.values.sum
  }
}