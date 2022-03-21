import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object WordCount extends App{

  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]","wordcount")
  val file = sc.textFile("D:/search_data.txt")
  val split1 = file.flatMap(x => x.split(" "))
  val add = split1.map(x => (x,1))
  val wc = add.reduceByKey((x,y) => x+y)
  wc.collect().foreach(println)
}