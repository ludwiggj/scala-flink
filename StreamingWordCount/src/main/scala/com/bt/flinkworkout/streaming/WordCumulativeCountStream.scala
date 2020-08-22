package com.bt.flinkworkout.streaming

import com.bt.flinkworkout.{TEST_FILE, streamExecutionEnvironment}
import org.apache.flink.streaming.api.scala._

object WordCumulativeCountStream {
  def main(args: Array[String]): Unit = {
    val env = streamExecutionEnvironment

    val text = env.readTextFile(TEST_FILE)

    val data: DataStream[Array[String]] = text.map { x =>
      x.split(",")
    }

    val dataTyped: DataStream[(String, Int)] = data.map { x =>
      (x(0), x(1).toInt)
    }

    val result = dataTyped.keyBy(0).sum(1)

    result.print()

    env.execute("WordCumulativeCountStream")
  }
}