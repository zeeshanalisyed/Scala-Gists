import scala.io.Source
import java.io.InputStream


object Input {
 def ProcessInput(in: InputStream): List[String] = {
    val lines = Source.fromInputStream(in).getLines()
    
    val n = lines.next().toInt
    var list = List[String]()

    var i = 1
    while(i <= n) {
      val str = lines.next().mkString
      list = list:+str
      i = i + 1
    }
    list
 }
  def main(args: Array[String]) {
     
  }
}
