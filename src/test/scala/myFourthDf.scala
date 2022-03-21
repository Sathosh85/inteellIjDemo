import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object myFourthDf extends App {

  Logger.getLogger("org").setLevel(Level.ERROR)

  val myRegEx ="""^(\S+) (\S+)\t(\S+)\,(\S+)""".r

  case class Orders(order_id:Int,customer_id:Int,order_status:String)

  def parser(line: String)={
    line match {
      case myRegEx(order_id,date,customer_id,order_status) =>
        Orders(order_id.toInt,customer_id.toInt,order_status)
    }
  }

  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name","Transformation")
  sparkConf.set("spark.master","local[2]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .getOrCreate()

  val lines = spark.sparkContext.textFile("C:\\Users\\Santhosh\\Desktop\\New folder\\orders_new.txt")

  import spark.implicits._

  val ordersDs = lines.map(parser).toDS().cache()

  ordersDs.printSchema()

  ordersDs.select("order_id").show()

  ordersDs.groupBy("order_status").count().show()

  val ordersDf = lines.map(parser).toDF()

  spark.stop()


}
