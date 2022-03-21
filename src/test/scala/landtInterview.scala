import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object landtInterview extends App {

  Logger.getLogger("org").setLevel(Level.ERROR)

  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name","l and T interview")
  sparkConf.set("spark.master","local[2]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .getOrCreate()

  val file1Schema = StructType(List(
    StructField("Id",IntegerType),
    StructField("name",StringType),
    StructField("Dept",StringType)
  ))

  val df1 = spark.read
    .format("csv")
    .option("header",true)
    .schema(file1Schema)
    .option("path,"")
    .load()


}
