//
// Copy/paste problem here
//

import scala.io.StdIn._ // import all standard inputs
import scala.io._
import java.io._
import scala.util.matching.Regex

// custom exceptions
class UndefinedVariable(s: String) extends Exception(s){}
class InvalidOperatorError(s: String) extends Exception(s){}

class Application(src: String = "none"){
  val filename: String = src
  var strings: Map[String, String] = Map()
  var integers: Map[String, Int] = Map()  
  //val opps: Map[String, Callable]
  val errors: List[Throwable] = List()

  def read(): Unit = {
    if(filename == "none") return repl()

    val file: BufferedSource = Source.fromFile(filename)
    for(line <- file.getLines() if line != "end") parseLine(line)
    file.close()
  }

  private def repl(): Unit = {
    var line: String = ""

    do{
      parseLine(line)
      line = readLine("cse-116 >>> ")
    } while(line != "end")
  }

  def parseLine(line: String): Unit = {
    val comment: Regex = "^//.+".r
    val ints: Regex = """^integer (\w)\s?(=)\s?(.+)$""".r
    val strs: Regex = """^string (\w)\s?(=)\s?\"(.+)\"$""".r

    line match {
      case comment(_*) =>
      case ints(vari, _, value) => integers += (vari -> evaluateNum(value));
      case strs(vari, _, value) => strings += (vari -> evaluateStr(value));
      case _ => 
    }
  }

  def evaluateNum(line: String): Int = {
    val digits: Regex = """^(\d+)$""".r
    val statement: Regex = """^(\w+)\s?([+\/*-])\s?(\w+)$""".r
    line match {
      case digits(num) => num.toInt
      case statement(v1, op, v2) => {
        try {
          opporateNum(v1.toInt, op, v2.toInt)
        } catch {
          case ex: java.lang.NumberFormatException => {
            if(integers.get(v1) != None && integers.get(v2) != None)
              opporateNum(integers(v1), op, integers(v2))
            else 
              throw new UndefinedVariable(s"Variable $v1 or $v2 is undefined.")
          }
        }
      }
    }
  }

  def opporateNum(v1: Int, op: String, v2: Int): Int = {
    val p: Regex = """\+""".r
    val mi: Regex = """-""".r
    val d: Regex = """\/""".r
    val mu: Regex = """\*""".r
    op match {
      case p(_*) => v1 + v2
      case mi(_*) => v1 - v2
      case d(_*) => v1 / v2
      case mu(_*) => v1 * v2
    }
  }

  def evaluateStr(line: String): String = {
    val string: Regex = """^([\w]+)$""".r
    val statement: Regex = """^(\w+)\s?([+\/*-])\s?(\w+)$""".r
    line match {
      case string(str) => str
      case statement(v1, op, v2) => {
        try {
          opporateStr(v1, op, v2)
        } catch {
          case ex: java.lang.NumberFormatException => {
            if(strings.get(v1) != None && strings.get(v2) != None)
              opporateStr(strings(v1), op, strings(v2))
            else 
              throw new UndefinedVariable(s"Variable $v1 or $v2 is undefined.")
          }
        }
      }
    }
  }

  def opporateStr(v1: String, op: String, v2: String): String = {
    val p: Regex = """\+""".r
    val mu: Regex = """\*""".r
    op match {
      case p(_*) => v1 + v2
      case mu(_*) => v1 * v2.toInt
      case _ => throw new InvalidOperatorError(s"$op is not a valid operator on type String")
    }
  }

}

object Test {
  def main(args: Array[String]): Unit = {
    val app = new Application("../src/program.txt")

    app.read()

    println(app.integers)
    println(app.strings)
  }
}