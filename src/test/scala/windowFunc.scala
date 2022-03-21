import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object windowFunc extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)

  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name","window function")
  sparkConf.set("spark.master","local[2]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .getOrCreate()

  val dataDf = spark.read
    .format("csv")
    .option("inferSchema",true)
    .option("header",true)
    .option("path","E:\\New folder\\hadoop\\Week12 Apache Spark - Structured API Part-2\\2- Download Week12 Practice Datasets\\windowdata")
    .load()

  dataDf.printSchema()

  spark.stop()


}
