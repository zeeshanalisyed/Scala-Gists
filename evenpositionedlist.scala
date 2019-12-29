import java.io.InputStream
import scala.io.Source


object TestName {
  def f(arr:List[Int]):List[Int] = {                
     (arr.indices.collect { case i if i % 2 == 1 => arr(i) }).toList
  }
    
    def main(args: Array[String]) {
      val numbers: List[Int] = Iterator.continually(io.StdIn.readLine)
                 .takeWhile(Option(_).fold(false)(_.nonEmpty)).map(_.toInt).toList
                 
      print(f(numbers))
    }
}
