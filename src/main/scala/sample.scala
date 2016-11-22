import java.util.Date

import org.apache.spark.SparkContext

/**
  * Created by Mabbasi on 11/19/2016.
  */
object sample {
  def main(args: Array[String]) {
//    val logFile = "src/data/sample.txt"
    val logFile = "E://share/fardi/identity.2016-11-19"

    val sc = new SparkContext("local", "Simple App", "E://spark-0.9.1")//,
    val logDataCount = sc.textFile(logFile)
    println("Count :"+logDataCount.count() +"first record :"+ logDataCount.first())
    val logData = sc.textFile(logFile).cache()
    val start = new Date()
    val numTHEs = logData.filter(line => line.contains("USERNAME_OR_PASSWORD_IS_INVALID")).count()
    val numTHEsa = logData.filter(line => line.contains("a")).count()
    val numTHEsb = logData.filter(line => line.contains("b")).count()

    val end = new Date()
    println("Lines with the: %s".format(numTHEs) + "   Lines with the: %s".format(numTHEsa) + "   Lines with the: %s".format(numTHEsb))
    println(end.getTime() - start.getTime)

  }

}
