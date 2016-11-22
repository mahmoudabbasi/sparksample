import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Mabbasi on 11/21/2016.
  */
object sampledb2 {

  def main(args: Array[String]) {
    val conf = new SparkConf()
      .setMaster("local[1]")
      .setAppName("GetEmployee")
      .set("spark.executor.memory", "1g")

    val sc = new SparkContext(conf)

    // Obtain SQLContext
    val sqlContext = new  SQLContext(sc)

    // Construct DataFrame from Employee table,
    // passing the Database URL and Driver class
    // to the sqlContext.load( ) API


    //val sqlContext = new org.apache.spark.sql.SQLContext(sc)


    val employeeDF = sqlContext.load("jdbc", Map(
      "url" -> "jdbc:db2://192.168.53.62:50000/SMS_API:user=db2inst1;password=123;",
      "driver" -> "com.ibm.db2.jcc.DB2Driver",
      "dbtable" -> "SMS.EMPLOYEE"))

    // show the DataFrame contents
    employeeDF.show();

  }
}
