import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.sql.{SparkSession, types}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType, TimestampType}

import java.sql.Timestamp

object mySecondDf extends App {

  Logger.getLogger("org").setLevel(Level.ERROR)

  case class Orders(orderid:Int,orderdate:Timestamp, customerid:Int, status:String)

  val sparkConf = new SparkConf()
    sparkConf.set("spark.app.name","my second df")
    sparkConf.set("spark.master","local[2]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .getOrCreate()

  val orderSchema = StructType(List(
    StructField("orderid",IntegerType),
    StructField("orderdate",TimestampType),
    StructField("customerid",IntegerType),
    StructField("status",StringType)
  ))

  //val orderSchemaDDL = "orderid Int, orderdate String, custid Int, orderstatus String"
  //val ddlSchema = StructType.fromDDL(orderSchemaDDL)

  //csv file
  val orderDf = spark.read
    .format("csv")
    .option("header", true)
    .schema(orderSchema)
    .option("path","C:\\Users\\Santhosh\\Desktop\\New folder\\orders.csv")
    .load

  //json file
  /*val orderDf1 = spark.read
    .format("json")
    .option("path","C:\\Users\\Santhosh\\Desktop\\New folder\\player.json.txt")
    .option("mode","FAILFAST")
    .load*/

  //parquet file
  /*val orderDf = spark.read
    .option("path","C:\\Users\\Santhosh\\Desktop\\New folder\\users.parquet")
    .load*/

  //dataframe to dataset conversion

  import spark.implicits._

  val orderDs = orderDf.as[Orders]

  orderDs.printSchema()

  orderDs.show(false)

  //scala.io.StdIn.readLine()
  spark.stop()

}

