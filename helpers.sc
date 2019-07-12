package helpers{
  import scala.io.StdIn._
  import scala.collection.mutable.ListBuffer
  import util.control.Breaks._

  object get{
    def integer(prompt: String): Int = {
      print(prompt);

      var number: Int = 0;

      try {
        number = readInt();
      } catch {
        case _: Throwable => number = integer(prompt);
      }

      return number;
    }

    def float(prompt: String): Float = {
      print(prompt);

      var number: Float = 0;

      try {
        number = readFloat();
      } catch {
        case _: Throwable => number = integer(prompt);
      }

      return number;
    }

    def floatList(prompt: String, flag: String): List[Float] = {
      var arr: List[Float] = List();
      do {
        var number: String = readLine(prompt);
        
        if (number == flag) return arr;

        try {
          arr = number.toFloat::arr;
        } catch {
          case _: Throwable => println("You must enter a number.");
        }

      } while (true)

      return arr
    }

    def stringList(prompt: String, flag: String): List[String] = {
      var arr: List[String] = List();
      while (true) {
        var res: String = readLine(prompt);
        if (res == flag) return arr;
        arr = res::arr;
      }
      return arr
    }
  }
}
