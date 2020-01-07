import scala.io.Source
import scala.math._


object Solution {

  def mean(elements: List[Float],n: Int): Float = elements.sum/n

  def sqr(x: Float): Float = x * x
  def stdviation(numbers: List[Float], n: Int): Double = {
    val _mean: Float = mean(numbers, n)
    sqrt(
      numbers.map(
        i => (i - _mean)
      ).map(sqr).reduce((a, b) => a + b)/n
    )
  }
  // with 1 decimle places rounded by default
  def round(number: Double, p: Int = 10): Double = (math rint number * p) / p

  def main(args: Array[String]) {
    val lines = Source.fromInputStream(System.in).getLines()
    val n = lines.next().toInt
    var numbers: List[Float] = lines.next().mkString.split(" ").map(_.toFloat).toList


    println(round(stdviation(numbers, n)))
  }
}
import scala.io.Source
import scala.math._


object Solution {

  def mean(elements: List[Float],n: Int): Float = elements.sum/n

  def sqr(x: Float): Float = x * x
  def stdviation(numbers: List[Float], n: Int): Double = {
    val _mean: Float = mean(numbers, n)
    sqrt(
      numbers.map(
        i => (i - _mean)
      ).map(sqr).reduce((a, b) => a + b)/n
    )
  }
  // with 1 decimle places rounded by default
  def round(number: Double, p: Int = 10): Double = (math rint number * p) / p

  def main(args: Array[String]) {
    val lines = Source.fromInputStream(System.in).getLines()
    val n = lines.next().toInt
    var numbers: List[Float] = lines.next().mkString.split(" ").map(_.toFloat).toList


    println(round(stdviation(numbers, n)))
  }
}
