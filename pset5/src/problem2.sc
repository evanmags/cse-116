//
// Copy/paste problem here
//

import scala.io.StdIn._ // import all standard inputs
import helpers.get._ // import helpers, get user input functions
import scala.util.Random

class Node(val value: Int){
  var right: Node = null
  var left: Node = null
}
class SortedList {
  var head: Node = null
  var sortedL: List[Int] = List()  

  def add(num: Int): Unit = {
    if (head == null) head = new Node(num)
    else place(num, head)
  }

  private def place(num: Int, trav: Node): Unit = {
    if (num <= trav.value){
      if(trav.left == null) trav.left = new Node(num)
      else place(num, trav.left)
    }
    else {
      if(trav.right == null) trav.right = new Node(num)
      else place(num, trav.right)
    }
  }

  private def printNode(n: Node): Unit = {
    if(n == null) return ()

    printNode(n.left)
    // println(n.value)
    sortedL = n.value :: sortedL
    printNode(n.right)
  }

  def printTree(): Unit = {
    printNode(head)
    println(sortedL.reverse)
  }
}

object problem2 {
  def main(args: Array[String]): Unit = {
    val sl: SortedList = new SortedList()
    val rndm: Random = new Random()

    for(n <- 0 until 20) sl.add(rndm.nextInt(20))
    sl.printTree()
  }
}