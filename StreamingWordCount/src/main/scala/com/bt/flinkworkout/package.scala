package com.bt

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.api.scala.ExecutionEnvironment

package object flinkworkout {
  val TEST_FILE = "./src/main/resources/test.csv"

  def streamExecutionEnvironment = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    env.getConfig.disableSysoutLogging()
    env
  }

  def batchExecutionEnvironment = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    env.getConfig.disableSysoutLogging()
    env
  }
}