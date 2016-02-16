package com.thor.rest.position

/**
  * Created by toantran on 2/15/16.
  */
object PositionResponse {
  case class Positions(accountId: String, accountCd: String, instrumentId: String, instrumentCd: String, quantity: String)
}
