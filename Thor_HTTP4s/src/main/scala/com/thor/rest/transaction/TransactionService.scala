package com.thor.rest.transaction

import org.apache.spark.{SparkConf, SparkContext}
import org.http4s.dsl._
import org.http4s.server._
import org.http4s.server.middleware.AutoSlash

import scala.concurrent.ExecutionContext


/**
  * Created by toantran on 2/14/16.
  */
object TransactionService {


  def service(implicit executionContext: ExecutionContext = ExecutionContext.global): HttpService = Router(
    "/v1/thor/transactions" -> allTransactions,
    "/v1/thor/transactions/accounts" -> filterTransactions
  )


  def allTransactions(implicit executionContext: ExecutionContext) = AutoSlash.apply(HttpService {
    case GET -> Root =>
      Ok("This is the transaction service")
    case GET -> Root / "accounts" =>
      Ok("all transactions for accounts")

  })

  def filterTransactions(implicit executionContext: ExecutionContext) = AutoSlash.apply(HttpService {
    case GET -> Root / account_id =>
      Ok("account for: " + account_id)
    case GET -> Root / account_id / "instruments" / instrument_id =>
      Ok("account for: " + account_id + " and for instrument: " + instrument_id)
  })


}
