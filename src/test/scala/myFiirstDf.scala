import org.apache.commons.net.ntp.TimeStamp
import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

case class OrdersData(order_id:Int,order_date:TimeStamp,order_customer_id:Int,order_status:String)

object myFiirstDf extends App{
  Logger.getLogger("org").setLevel(Level.ERROR)

  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name","My First DF")
  sparkConf.set("spark.master","local[2]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .getOrCreate()

  val orderDf = spark.read //action
    .option("header",true)
    .option("inferSchema",true)  //action
    .csv("C:\\Users\\Santhosh\\Desktop\\New folder\\orders.csv")

  //orderDf.show()  //action
  //orderDf.printSchema()

  val groupOrdersDf = orderDf
    .repartition(4)
    .where("order_customer_id > 10000")
    .select("order_id","order_customer_id")
    .groupBy("order_customer_id")
    .count()

  //dataframe to dataset
  import spark.implicits._

  val orderDs = groupOrdersDf.as[OrdersData]

  orderDs.filter(x => x.order_id < 10).show()


  //groupOrdersDf.show()

  //groupOrdersDf.foreach( x => {
  //  println(x)
  //})

  //Logger.getLogger(getClass.getName).info("my app is successfully implemented")

  //scala.io.StdIn.readLine()

  spark.stop()

}