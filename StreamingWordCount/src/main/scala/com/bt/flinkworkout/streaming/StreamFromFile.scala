package com.bt.flinkworkout.streaming

import com.bt.flinkworkout.{TEST_FILE, streamExecutionEnvironment}
import org.apache.flink.streaming.api.scala._

object StreamFromFile {
  def main(args: Array[String]): Unit = {
    val env = streamExecutionEnvironment

    val text: DataStream[String] = env.readTextFile(TEST_FILE)

    text.print()

    env.execute("Stream from file")
  }
}