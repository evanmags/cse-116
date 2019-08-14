//
// Copy/paste problem here
//

import scala.io.StdIn._ // import all standard inputs
import helpers.get._ // import helpers, get user input functions
import scala.collection.mutable.ArrayBuffer
import scala.util.matching.Regex

class sStack(){
  var s: ArrayBuffer[String] = ArrayBuffer()
  def push(n: String): Unit = {
    s.insert(0, n)
  }

  def pop(): String = {
    if(s.length > 0) return s.remove(0)
    return " "
  }
}

object problemX {
  val op: Regex = """([*+-\\)\\(\\%])""".r
  val digit: Regex = """(\d)""".r
  val equation: String = "1 + 1 + 2 * (4 + 5) - 3"
  // val eq: String = "1 1 2 + + 4 5 + * 3 -"
  // val eq: String = "33"
  
  def main(args: Array[String]): Unit = {
    val postfixed: String = toPostfix(equation) 
    println(postfixed)
    val result: Int = evaluate(postfixed) 
    println(result)
  }

  def toPostfix(eq: String): String = {
    var intermediate: String = ""
    val m: Stack = new Stack()
    var skip = false
    for (i <- 0 until eq.length()){
      var c = eq(i).toString
      if(c.toString != " " && !skip){
        c match {
          case digit(d) => intermediate += s" ${d.toString}"
          case op(o) => {
            if (o.toString == "-" && "1234567890".contains(eq(i+1).toString)){
              intermediate += s" ${o.toString}${eq(i+1).toString}"
              skip = true
            }
            else if(isHighPrecidence(o.toString)){
              var a = ""
              while(!isHighPrecidence(a) && a != " "){
                intermediate += { if(a != "") s" $a" else "" }
                a = m.pop()
              }
              m.push(o.toString)
              if (a != " ") m.push(a)
            }
            else if (o.toString == ")"){
              var a = ""
              while (a != "(" && a != " "){
                intermediate += { if(a != "") s" $a" else "" }
                a = m.pop()
              }
              intermediate += s" ${m.pop()}"
            }
            else m.push(o.toString)
          }
          case _ => 
        }
      }
      else skip = false
    }
    for(a <- m.s) intermediate += s" $a" 

    return intermediate.trim()
  }

  def isHighPrecidence(c: String): Boolean = {
    return if(c == "*" || c == "/" || c == "%") true else false
  }
  def isLowPrecidence(c: String): Boolean = {
    return if(c == "+" || c == "-") true else false
  }

  def evaluate(eq: String): Int = {
    var total: Int = 0
    var skip = false
    val m: Stack = new Stack()
    for(i <- 0 until eq.length()){
      println(m.s)
      var c = eq(i).toString
      if(c.toString != " " && !skip){
        if(c == "-" && i+1 < eq.length() && "1234567890".contains(eq(i+1).toString)){
          m.push(s"$c${eq(i+1).toString}")
          skip = true
        }
        else {
          c match {
          case digit(d) => m.push(d.toString)
          case op(o) => {
            val a = o.toString
            if(a == "+") m.push((m.pop().toInt + m.pop().toInt).toString)
            else if(a == "*") m.push((m.pop().toInt * m.pop().toInt).toString)
            else if(a == "-") {
              val b = m.pop().toInt
              val c = m.pop().toInt
              m.push((c - b).toString)
            }
            else if(a == "/") {
              val b = m.pop().toInt
              val c = m.pop().toInt
              m.push((c / b).toString)
            }
          }
          case _ => 
          }
        }
      }
      else skip = false
    }
    return m.pop().toInt
  }
}