package example.algo
import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Algorithm {

  def roundAt4(n: Double): Double = (math rint n * 10000) / 10000
  def exponential(x: Double): Double = {
    if (x == 0) {
      return 1
    } else {
      return (scala.math.pow(x,x.toInt)/factorial(x)) + exponential(x - 1)
    }
  }
  def factorial(x:Double) : Double = {

    def originalTail (acc:Double,n:Double) : Double = {
      if (n == 0) acc
      else originalTail(acc * n, n - 1)
    }

    originalTail(1,x)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

//    for (nItr <- 1 to n) {
//      val x = stdin.readLine.trim.toDouble
//      println(exponential(n, x))
//    }
    println(exponential(2.0))
  }
}
