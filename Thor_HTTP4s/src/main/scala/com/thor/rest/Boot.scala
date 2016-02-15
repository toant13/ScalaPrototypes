package com.thor.rest

import org.http4s.server.blaze.BlazeBuilder

/**
  * Created by toantran on 2/14/16.
  */
object Boot extends App{
  BlazeBuilder.bindHttp(8080)
    .mountService(ThorService.service, "/")
    .run
    .awaitShutdown()
}
