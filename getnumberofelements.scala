object Solution {
  def f(n: List[Int]): Int = {
    n.map(_=>1).sum
  }

  def main(args: Array[String]) {
    val lines = Source.fromInputStream(System.in).getLines()
    val n = lines.next().toInt
    var numbers: List[Int] = lines.next().mkString.split(" ").map(_.toInt).toList


    println(f(numbers))
  }
}
