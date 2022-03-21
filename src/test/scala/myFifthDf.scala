import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, column, expr}

object myFifthDf extends App{

  Logger.getLogger("org").setLevel(Level.ERROR)

  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name","fifth df")
  sparkConf.set("spark.master","local[2]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .getOrCreate()

  val orderDf = spark.read
    .format("csv")
    .option("inferSchema",true)
    .option("path","C:\\Users\\Santhosh\\Desktop\\New folder\\orders.csv")
    .option("header",true)
    .load

  //column string
  orderDf.select("order_id","order_status").show

  ///column object
  import spark.implicits._

  orderDf.select(column("order_id"),col("order_status"),$"order_customer_id",'order_date).show

  //column expression
  orderDf.select(column("order_id"),expr("concat(order_status,'_STATUS')")).show(false)

  orderDf.selectExpr("order_id","order_date","concat(order_status,'_STATUS')").show(false)

  spark.stop()

}
