package com.thor.rest.transaction

import org.apache.spark.{SparkConf, SparkContext}
import org.http4s.dsl._
import org.http4s.server._
import org.http4s.server.middleware.AutoSlash


/**
  * Created by toantran on 2/14/16.
  */
object TransactionService {

  val sparkConf: SparkConf = new SparkConf().setAppName("spark-spray-starter").setMaster("local")
  val sc: SparkContext = new SparkContext(sparkConf)

  val endpoints = AutoSlash.apply(HttpService {
    case GET -> Root / "v1" / "thor" / "transactions" / "accounts" =>
      Ok("Get list of all transactions " + sc.version)

  })



}
