package com.thor.rest.transaction

import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by toantran on 2/15/16.
  */
object TransactionExtract {

  val sparkConf: SparkConf = new SparkConf().setAppName("spark-spray-starter").setMaster("local")
  val sc: SparkContext = new SparkContext(sparkConf)

}
