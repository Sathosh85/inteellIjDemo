import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.sql.{SaveMode, SparkSession}
import org.apache.spark.sql.types.{DoubleType, IntegerType, LongType, StringType, StructField, StructType}
import com.databricks.spark.avro._



object sparkAssign1 extends App{

  Logger.getLogger("org").setLevel(Level.ERROR)

  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name","my spark Assignment 1")
  sparkConf.set("spark.master","local[2]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .getOrCreate()

  val windowSchema = StructType(List(
    StructField("country", StringType,nullable = false),
    StructField("weeknum", IntegerType,nullable = true),
    StructField("numinvoices",IntegerType,nullable = false),
    StructField("totalquality",LongType,nullable = false),
    StructField("invoicevalue",DoubleType,nullable = true)
  ))

  val windowDf = spark.read
    .schema(windowSchema)
    .format("csv")
    .option("path","C:\\Users\\Santhosh\\Desktop\\New folder\\windowdata.csv")
    .load

  windowDf.printSchema()

  windowDf.show()

 /* windowDf.write
    .partitionBy("country","weeknum")
    .mode(SaveMode.Overwrite)
    .option("path","C:\\Users\\Santhosh\\Desktop\\New folder\\widowdata.parquet")
    .save()*/

  windowDf.write
    .partitionBy("country")
    .mode(SaveMode.Overwrite)
    .format("com.databricks.spark.avro")
    .option("path","C:\\Users\\Santhosh\\Desktop\\New folder\\widowdata1")
    .save()

  spark.stop()


}
