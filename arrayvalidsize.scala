import scala.collection.JavaConverters._

object Solution {
  def solution(a: Array[Int]): Int = {
    var counter: Int = 0
    a.foreach { e =>
        if (e < a.size && e > 0) {
          counter = counter +1
        }
    }
    counter
  }
  def main(args: Array[String]) {
    println(solution(Array(1, 4, -1, 3, 2)))
  }
}
