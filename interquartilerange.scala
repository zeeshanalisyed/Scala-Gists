import java.io.InputStream
import scala.io.Source


object Solution {

  def median(elements: List[Float],n: Int): Float = {
    if (n % 2 >= 1) elements(n / 2)
    else {
      val (up, down) = elements.splitAt(n / 2)
      (up.last + down.head) / 2
    }
  }
  def generateQuartileLists(n: List[Float]): (List[Float], List[Float]) = {
    var (lower, upper): (List[Float], List[Float]) = n.splitAt(n.size/2)
    upper = upper.drop(1)
    (lower, upper)
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
    val (lower, upper) = generateQuartileLists(data)
    print((median(upper, upper.size) - median(lower, lower.size)).floor)
  }
}
