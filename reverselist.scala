import scala.io.Source
import scala.math._


object Solution {
  def reverse(n: List[Int]): List[Int] = {
    var a: List[Int] = n
    var b = List[Int]()
    while(a.length != 0) {
      b = a.head :: b
      a = a.tail
    }
    b
  }

  def main(args: Array[String]) {
    val lines = Source.fromInputStream(System.in).getLines()
    val n = lines.next().toInt
    var numbers: List[Int] = lines.next().mkString.split(" ").map(_.toInt).toList


    println(reverse(numbers))
  }
}
