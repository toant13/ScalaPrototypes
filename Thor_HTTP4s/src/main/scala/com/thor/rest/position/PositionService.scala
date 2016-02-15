package com.thor.rest.position

import org.apache.spark.{SparkContext, SparkConf}
import org.http4s.dsl._
import org.http4s.server.HttpService
import org.http4s.server.middleware.AutoSlash

/**
  * Created by toantran on 2/15/16.
  */
object PositionService {

  val sparkConf: SparkConf = new SparkConf().setAppName("spark-spray-starter").setMaster("local")
  val sc: SparkContext = new SparkContext(sparkConf)


  val endpoints = AutoSlash.apply(HttpService {
    case GET -> Root / "v1" / "thor" / "positions" / "accounts" =>
      Ok("other service")
  })
}
