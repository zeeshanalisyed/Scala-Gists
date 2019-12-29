import java.io.InputStream
import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets

import scala.io.Source
import scala.util.matching.Regex

object Calculator {
    def data_parser(in: InputStream): (List[Float], List[Float]) = {
       val lines = Source.fromInputStream(in).getLines()
       val n = lines.next().toInt
       var Xstr: String = lines.next().mkString
       var Wstr: String = lines.next().mkString
       (Xstr.split(" ").map(_.toFloat).toList, Wstr.split(" ").map(_.toFloat).toList)
    }
    def weightedMean(x: List[Float], w: List[Float]): Float = {
      val dividend: Float = x.zip(w).map { 
        case(a, b) => a * b 
      }.reduce((a, b) => a + b)
      
      val divisor: Float = w.reduce((a, b) => a + b)
      
      dividend/divisor
    }
    def main(args: Array[String]) {
      val (x, y) = data_parser(System.in)
      val mean: Float = weightedMean(x, y)
      print(f"$mean%1.1f")
    }
}

