import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.sql.{SparkSession, functions}
import org.apache.spark.sql.functions.{avg, count, countDistinct, expr, sum}

object orderData extends App{
  Logger.getLogger("org").setLevel(Level.ERROR)

  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name","Order data")
  sparkConf.set("spark.master","local[2]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .getOrCreate()

  val invoiceDf = spark.read
    .format("csv")
    .option("inferSchema",true)
    .option("header",true)
    .option("path","C:\\Users\\Santhosh\\Desktop\\New folder\\order_data.csv")
    .load()

  //invoiceDf.show()


/* ************* simple aggregation **************
  //column object
  invoiceDf.select(
    count("*").as("totalRows"),
    sum("Quantity").as("totalQuantity"),
    avg("UnitPrice").as("avgUnitPrice"),
    countDistinct("InvoiceNo").as("distinctInvoice")
  ).show()

  //string expression
  invoiceDf.selectExpr("count(*) as totalRows",
    "sum(Quantity) as totalQuantity",
    "avg(UnitPrice) as avgUnitPrice",
    "count(Distinct(InvoiceNo)) as distinctInvoice").show()

  //sql expression
  invoiceDf.createOrReplaceTempView("invoiceDf")
  spark.sql(
    "select count(*),sum(Quantity),avg(UnitPrice),count(distinct(InvoiceNo)) from invoiceDf"
  ).show()
*/

  ///////////// group aggregation //////////////////
  //column object
  invoiceDf.groupBy("Country","InvoiceNo")
    .agg(sum("Quantity").as("totalQuantity"),
      sum(expr("Quantity * UnitPrice")).as("totalPrice")).show()

  //string expression
  invoiceDf.groupBy("Country","InvoiceNo")
    .agg(expr("sum(Quantity) as totalQuantity"),
      expr("sum(Quantity * UnitPrice) as totalPrice")).show()

  //spark sql expression
  invoiceDf.createOrReplaceTempView("sales")
  spark.sql(
    """select Country,InvoiceNo,sum(Quantity),sum(Quantity * UnitPrice) from sales group by Country,InvoiceNo""").show()

  spark.stop()

}
