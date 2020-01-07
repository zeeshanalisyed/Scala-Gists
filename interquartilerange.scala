import java.io.InputStream
import scala.io.Source


object Test {

  def median(elements: List[Float],n: Int): Float = {
    if (n % 2 == 1) elements(n / 2)
    else {
      val (up, down) = elements.splitAt(n / 2)
      (up.last + down.head) / 2
    }
  }
  def getMiddle(numbers: List[Float], n: Int): Float = median(numbers, numbers.size)

  def getRanges(numbers: List[Float], _median: Float, n: Int): (List[Float], List[Float]) = {
    var (lower, upper) = numbers.partition(_ < _median)
    upper = upper.drop(1)
    (lower, upper)
  }

  def quartile(numbers: List[Float], n: Int): (Float, Float, Float) = {
    val _median: Float = getMiddle(numbers, n)
    val (lower, upper) = getRanges(numbers, _median, n)
    val _lower: Float = median(lower, lower.size)
    var _upper: Float = median(upper, upper.size)
    if (n % 2 == 0) {
      _upper = _upper - 1
    }
    return (_lower, _median, _upper);
  }
  def generateFrequencyData(n: List[Float], f: List[Int]): List[Float] = {
    var list: List[Float] = List[Float]()
    for (i <- 0 to n.size -1) {
      val l = List.fill(f(i))(n(i))
      list = list ::: l
    }
    list.sorted
  }

  def main(args: Array[String]) {
    val lines = Source.fromInputStream(System.in).getLines()
    val n = lines.next().toInt
    var numbers: List[Float] = lines.next().mkString.split(" ").map(_.toFloat).toList
    var frequecny: List[Int] = lines.next().mkString.split(" ").map(_.toInt).toList
    val data: List[Float] = generateFrequencyData(numbers, frequecny);
    val (lower, middle, upper) = quartile(data, data.size)
    println(upper - lower)
  }
}
