import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.sql.{SaveMode, SparkSession}

object myThirdDf extends  App{

  Logger.getLogger("org").setLevel(Level.ERROR)

  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name","my Third Df")
  sparkConf.set("spark.master","local[2]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .enableHiveSupport()
    .getOrCreate()

  val orderDf = spark.read
    .format("csv")
    .option("inferSchema",true)
    .option("path","C:\\Users\\Santhosh\\Desktop\\New folder\\orders.csv")
    .option("header",true)
    .load

  orderDf.createOrReplaceTempView("orders")

  //val resultDf = spark.sql("select order_status,count(*) as status_count from orders group by order_status order by status_count desc")
  val order1Df = spark.sql("select * from orders")

  spark.sql("create database if not exists retail")

  //resultDf.show

  order1Df.write
    .format("csv")
    .mode(SaveMode.Overwrite)
    .partitionBy("order_status")
    .bucketBy(4,"order_customer_id")
    .sortBy("order_customer_id")
    .saveAsTable("retail.orderss1")

  spark.catalog.listTables("retail").show()

  //scala.io.StdIn.readLine()

  spark.stop()

}
