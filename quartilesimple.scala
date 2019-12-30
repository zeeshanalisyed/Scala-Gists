import java.io.InputStream
import scala.io.Source


object Calculator {
    
  def median(elements: List[Int],n: Int): Int = {
    if (n % 2 == 1) elements(n / 2)
    else {
      val (up, down) = elements.splitAt(n / 2)
      (up.last + down.head) / 2
    }
  }
  def getMiddle(numbers: List[Int], n: Int): Int = median(numbers, numbers.size)

  def getRanges(numbers: List[Int], _median: Int, n: Int): (List[Int], List[Int]) = {
    var (lower, upper) = numbers.partition(_ < _median)
    upper = upper.drop(1)
    (lower, upper)
  }
  
  def quartile(numbers: List[Int], n: Int): (Int, Int, Int) = {
    val _median: Int = getMiddle(numbers, n)
    val (lower, upper) = getRanges(numbers, _median, n)
    val _lower: Int = median(lower, lower.size)
    var _upper: Int = median(upper, upper.size)
    if (n % 2 == 0) {
      _upper = _upper - 1
    }
    return (_lower, _median, _upper);
  } 

  def main(args: Array[String]) {
    val lines = Source.fromInputStream(System.in).getLines()
    val n = lines.next().toInt
    var numbers: List[Int] = lines.next().mkString.split(" ").map(_.toInt).toList.sorted
    val (lower, middle, upper) = quartile(numbers, n)
    println(lower)
    println(middle)
    println(upper)
  }
}
