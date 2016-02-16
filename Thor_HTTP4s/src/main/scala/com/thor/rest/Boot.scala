package com.thor.rest

import com.thor.rest.position.PositionService
import com.thor.rest.transaction.TransactionService
import org.http4s.server.blaze.BlazeBuilder

/**
  * Created by toantran on 2/14/16.
  */
object Boot extends App{
  BlazeBuilder.bindHttp(8080)
    .mountService(TransactionService.service, "/")
    .mountService(PositionService.service, "/")
    .run
    .awaitShutdown()
}
