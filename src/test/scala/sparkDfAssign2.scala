import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.sql.{Encoders, SparkSession}
import scala.collection.JavaConversions._

object sparkDfAssign2 extends App{
  Logger.getLogger("org").setLevel(Level.ERROR)

  case class Window( country:String, weeknum:Int, numinvoices:Int, totalquality:Long, invoicevalue:Double)

  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name","spark dataframe assignment 2")
  sparkConf.set("spark.master","local[2]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .getOrCreate()

  val sc = spark.sparkContext

  val baseRdd = sc.textFile("C:\\Users\\Santhosh\\Desktop\\New folder\\windowdata.csv")

  val encoderSchema = Encoders.product[Window].schema

  //val windowDf = spark.createDataFrame(baseRdd,Window)



}
