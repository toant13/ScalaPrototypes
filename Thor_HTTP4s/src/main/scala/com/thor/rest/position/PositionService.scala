package com.thor.rest.position

import org.apache.spark.{SparkContext, SparkConf}
import org.http4s.dsl._
import org.http4s.server.{Router, HttpService}
import org.http4s.server.middleware.AutoSlash

import scala.concurrent.ExecutionContext

/**
  * Created by toantran on 2/15/16.
  */
object PositionService {

  def service(implicit executionContext: ExecutionContext = ExecutionContext.global): HttpService = Router(
    "/v1/thor/positions" -> allPositions,
    "/v1/thor/positions/accounts" -> filterPositions
  )


  def allPositions(implicit executionContext: ExecutionContext) = AutoSlash.apply(HttpService {
    case GET -> Root =>
      Ok("This is the position service")
    case GET -> Root / "accounts" =>
      Ok("position service")

  })

  def filterPositions(implicit executionContext: ExecutionContext) = AutoSlash.apply(HttpService {
    case GET -> Root / account_id =>
      Ok("account for: " + account_id)
    case GET -> Root / account_id / "instruments" / instrument_id =>
      Ok("account for: " + account_id + " and for instrument: " + instrument_id)
  })


}
