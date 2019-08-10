package com.fmino.countbyage

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

object Counter {

  def count(filePath: String): collection.Map[String, Long] = {
    val context: SparkContext = new SparkContext("local[*]", "counter")
    val lines: RDD[String] = context.textFile(filePath)
    // (The file format is userID, movieID, rating, timestamp)
    // getting rating field RDD
    val ratings: RDD[String] = lines.map(l => l.split("\t")(2))
    val resultMap: collection.Map[String, Long] = ratings.countByValue()
    context.stop()
    return resultMap
  }

}
