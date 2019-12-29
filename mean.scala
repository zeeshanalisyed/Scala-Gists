object Calculator {
    
    def mean(elements: Seq[Float],n: Int): Float = elements.sum/n

    def median(elements: Seq[Float],n: Int): Float = {
      if (n % 2 == 1) elements(n / 2)
      else {
        val (up, down) = elements.splitAt(n / 2)
        (up.last + down.head) / 2
      }
    }

    def mode(elements: Seq[Float]): Float = {
      val grouped = elements.groupBy(x => x).mapValues(_.size)
      val modeValue = grouped.maxBy(_._2)._2
      grouped.filter(_._2 == modeValue).map(_._1).min
    }

    def main(args: Array[String]) {
       val N = scala.io.StdIn.readInt()
       val line = scala.io.StdIn.readLine()
       val list = line.split(" ").map(_.toFloat).toSeq.sorted

       println(mean(list, N)) 
       println(median(list, N)) 
       println(mode(list)) 
    }
}
