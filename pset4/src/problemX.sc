//
// Copy/paste problem here
//

import scala.io.StdIn._ // import all standard inputs
import helpers.get._
import scala.io._
import java.io._
import scala.util.matching.Regex

// custom exceptions
class UndefinedVariable(s: String) extends Exception(s){}
class UndeclaredVariable(s: String) extends Exception(s){}
class InvalidOperatorError(s: String) extends Exception(s){}
class InvalidSyntaxError(s: String) extends Exception(s){}

class Interpreter(src: String){
  var variables: Map[String, String] = Map()
  val infile: String = src
  var errors: Boolean = false

  def readCode(): Unit = {
    val outfile = new PrintWriter(new FileWriter("result.txt"))
    if (infile == "none") {
      var line: String = ""
      do {
        evalForErrors(line, outfile)
        line = readLine(">>> ").trim
        println(s"INP: $line")
      } while(line != "end")
    }
    else {
      val file: BufferedSource = Source.fromFile(infile)
      for(line <- file.getLines() if line.trim != "end") evalForErrors(line, outfile)
      file.close()
    }
    outfile.close()
  }
  def runCode(): Unit = {
    if(!errors){
      val file: BufferedSource = Source.fromFile("result.txt")
      for(line <- file.getLines()) {
        parse(line.trim)
      }
      file.close()
    }
    else println("Too many errors to evaluate code")
  }
  private def evalForErrors(line: String, out: PrintWriter): Unit = {
    try {
      parse(line.trim, true)
      out.write(s"$line\n")
    } catch {
      case ex: Throwable => {
        errors = true
        out.write(s"$line\t // ${ex.getMessage}")
      }
    }
  }
  private def parse(line: String, forErrors: Boolean = false): Unit = {
    val comment: Regex = """^//.+""".r
    val declare: Regex = """^(integer|string) (\w)$""".r
    val assign: Regex = """^(\w)\s*=\s*(\"?[\w\s+-\\*%]*\"?)$""".r
    val read: Regex = """^read (\w)$""".r
    val display: Regex = """^display (.+)$""".r
    val blank: Regex = """^[\s\n]*$""".r
    try {
      line match {
        case comment(_*) => // do nothing if commented line
        case declare(_, vari) => variables += (vari -> "") // empty variable declared
        case assign(vari, value) => {  // variable assigned value
          if(variables.get(vari) == None) throw new UndeclaredVariable("")
          variables += (vari -> evaluate(value))
        }
        case read(vari) => { // built in read function
          if(variables.get(vari) == None) throw new UndefinedVariable("")
          val value: String = if(!forErrors) readLine(">>> ") else "5"
          variables += (vari -> evaluate(value))
        }
        case display(value) =>{
          if(forErrors) evaluate(value)
          else println(evaluate(value))
        } //  built in display function
        case blank(_*) => // ignore blank lines
        case _ => throw new InvalidSyntaxError("") // unrecognisable code
      }
    } catch {
      case ex: NoSuchElementException => throw new Exception("ERROR: Variable is undeclared\n")
      case ex: UndefinedVariable => throw new Exception("ERROR: Variable is undeclared\n")
      case ex: UndeclaredVariable => throw new Exception("ERROR: Variable must be declared before definition\n")
      case ex: InvalidOperatorError => throw new Exception("ERROR: Not a valid operation\n")
      case ex: NumberFormatException => throw new Exception("ERROR: Operation only valid with Integers\n")
      case ex: InvalidSyntaxError => throw new Exception("ERROR: Unrecognized syntax\n")
    }
  }
  private def evaluate(statement: String): String = {
    val opperation: Regex = """(\w|\d+)\s?([+\/*%-])\s?(\w|\d+)""".r
    val variable: Regex = """^(\w)$""".r
    val string: Regex = """^\"([\w\s:?!,.]+)\"$""".r
    val int: Regex = """^(\d+)$""".r
    statement match {
      case opperation(v1, op, v2) => {
        val v1isVar: Boolean = variables.get(v1) != None
        val v2isVar: Boolean = variables.get(v2) != None
        if(v1isVar && v2isVar) opperate(variables(v1).toInt, op, variables(v2).toInt)
        else if(v1isVar && !v2isVar) opperate(variables(v1).toInt, op, v2.toInt)
        else if(!v1isVar && v2isVar) opperate(v1.toInt, op, variables(v2).toInt)
        else opperate(v1.toInt, op, v2.toInt)
      }
      case int(v) => v
      case string(v) => v
      case variable(v) => variables(v)
      case _ => throw new InvalidOperatorError("")
    }
  }
  private def opperate(v1: Int, op: String, v2: Int): String = {
    val p : Regex = "\\+".r
    val mi : Regex = "-".r
    val d : Regex = "/".r
    val mu : Regex = "\\*".r
    val mo : Regex = "%".r
    val result: Int = op match {
      case p(_*) => v1 + v2
      case mi(_*) => v1 - v2
      case d(_*) => v1 / v2
      case mu(_*) => v1 * v2
      case mo(_*) => v1 % v2
    }
    result.toString
  }
}

object Test {
  def main(args: Array[String]): Unit = {
    val filename = if(args.length > 0) args(0) else "none"
    val app = new Interpreter(filename)
    app.readCode() // first loop read and check for errors
    app.runCode() // second loop evaluate
  }
}
