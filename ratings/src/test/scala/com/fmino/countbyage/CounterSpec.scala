package com.fmino.countbyage

import org.scalatest.FunSuite

class CounterSpec extends FunSuite {

  val dataFilePath : String = CounterSpec.testResourcesPath + "u.data"

  test("count should be a success") {
    val resultMap: collection.Map[String, Long] =
      Counter.count(dataFilePath)
    resultMap.foreach((entry : (String, Long)) => println(entry._1 + ": " + entry._2))
    /*
    4: 34174
    5: 21201
    1: 6110
    2: 11370
    3: 27145
     */

    assert(resultMap.get("1").exists(v => v == 6110L))
  }

  test("count should be a success 2") {
    val resultMap: collection.Map[String, Long] =
      Counter.count(dataFilePath)
    assert(resultMap.get("2").exists(v => v == 11370L))
  }

}

object CounterSpec {
  val testResourcesPath : String = "/home/fernando/sparkScala/countByAge/src/test/resources/"
}
