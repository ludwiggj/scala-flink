package com.bt.flinkworkout.batch

import com.bt.flinkworkout.{TEST_FILE, batchExecutionEnvironment}
import org.apache.flink.api.scala._

object WordCumulativeCountBatch {
  def main(args: Array[String]): Unit = {
    val env = batchExecutionEnvironment

    val text: DataSet[String] = env.readTextFile(TEST_FILE)

    val data: DataSet[Array[String]] = text.map { _.split(",") }

    // Total number of all fruit
    data.map { x => x(1).toInt }.reduce(_ + _).print()

    // Fruit summed by type
    data.map { x => (x(0), x(1).toInt) }.groupBy(0).sum(1).print()
  }
}