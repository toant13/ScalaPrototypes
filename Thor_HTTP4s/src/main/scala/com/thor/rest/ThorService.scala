package com.thor.rest

import org.http4s._
import org.http4s.server._
import org.http4s.dsl._
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

/**
  * Created by toantran on 2/14/16.
  */
object ThorService {

  val sparkConf: SparkConf = new SparkConf().setAppName("spark-spray-starter").setMaster("local")
  val sc: SparkContext = new SparkContext(sparkConf)

  val service = HttpService {
    case GET -> Root / "v1" / "thor" / "transactions" / "accounts" =>
      Ok("Get list of all transactions " + sc.version)

    case GET -> Root / "v1" / "thor" / "positions" / "accounts" =>
      Ok("Get list of all positions")
  }
}
