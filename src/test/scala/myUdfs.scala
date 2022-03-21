import org.apache.hadoop.hive.ql.exec.UDF
import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, expr, udf}

case class Person(name:String,age:Int,city:String)

object myUdfs extends App {

    def ageCheck(age:Int): String = {
  if (age > 18) "Y" else "N"
  }

  Logger.getLogger("org").setLevel(Level.ERROR)

  val sparkConf = new SparkConf()
  sparkConf.set("spark.app.name","UDF")
  sparkConf.set("spark.master","local[2]")

  val spark = SparkSession.builder()
    .config(sparkConf)
    .getOrCreate()

  val dataSet = spark.read
    .format("csv")
    .option("path","C:\\Users\\Santhosh\\Desktop\\New folder\\201125-161348.DATASET1")
    .option("inferSchema",true)
    .load()

  //dataSet.printSchema()

  import spark.implicits._

  val df1 = dataSet.toDF("name","age","city")
  val ds1 = df1.as[Person]

  //column expression udf

  val parseAgeFunction =  udf(ageCheck(_:Int): String)
  val df2 = df1.withColumn("adult",parseAgeFunction(col("age")))
  df2.show()


  //sql/string expression udfs

  spark.udf.register("parseAgeFunc1",ageCheck(_:Int):String)
  val df3 = df1.withColumn("adult",expr("parseAgeFunc1(age)"))
  df3.show()

  spark.catalog.listFunctions().filter(x => x.name == "parseAgeFunc1").show()
  spark.catalog.listFunctions().filter(x => x.name == "parseAgeFunction").show()

  //anonymous function
  //spark.udf.register("parseAgeFunc2",(x :Int ) =>{if (x >18)"Y" else "N"})

  spark.stop()

}
