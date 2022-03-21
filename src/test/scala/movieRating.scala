import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger


object movieRating extends App{

  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]","movieRating")

  val baseRdd = sc.textFile("C:\\Users\\Santhosh\\Desktop\\New folder\\ratings.dat").map(x => (x.split("::")(1).toInt,x.split("::")(2).toInt))
  //movieRating.take(20).foreach(println)

  val movieCount = baseRdd.map(x => (x._1,1)).reduceByKey((x,y)=>(x+y))
  val movieFilter = movieCount.filter(x => x._2 >= 1000)
  movieFilter.take(30).foreach(println)

}