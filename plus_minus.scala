object Calculator {
    def plusMinus(arr: Array[Int], n: Int): Unit = {
        val nOfp = arr.filter(isPossitive).size
        val nOfn = arr.filter(isNegative).size
        val nOfz = arr.filter(isZero).size
        println(ratio(nOfp, n))
        println(ratio(nOfn, n))
        println(ratio(nOfz, n))
    }
    def isPossitive(x: Int): Boolean = x > 0 
    def isNegative(x: Int): Boolean = x < 0 
    def isZero(x: Int): Boolean = x == 0 

    def ratio(x: Int, y: Int): Double = x.toFloat / y

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val n = stdin.readLine.trim.toInt

        val arr = stdin.readLine.split(" ").map(_.trim.toInt)
        
        plusMinus(arr, n)
    }
}
