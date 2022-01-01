package com.pmcatee.aoc2021

import com.pmcatee.aoclib.Day

object Day3 extends Day(2021, 3) {

  val matrix = input.map(_.map({
    case '0' => 0
    case '1' => 1
  }).toList)

  override val part1: Any = {

    val (g, l) = matrix
      .reduce((a, b) => a.zip(b) map { case (u, v) => u + v })
      .map({
        case c if c * 2 >= matrix.size => (1, 0)
        case _                         => (0, 1)
      })
      .unzip

    java.lang.Long.parseLong(g.mkString, 2) * java.lang.Long
      .parseLong(l.mkString, 2)
  }

  @annotation.tailrec
  def part2recursion(
      records: List[List[Int]],
      greaterOrLesser: Boolean,
      idx: Int = 0
  ): List[List[Int]] = {
    if (records.size == 1) records
    else {
      val g = if (greaterOrLesser ^ records.map(_(idx)).sum * 2 >= records.size) 1 else 0
      part2recursion(records.filter(_(idx) == g), greaterOrLesser, idx + 1)
    }
  }

  override val part2: Any = {
    val o2ratingRecord = part2recursion(matrix, false).head.mkString
    val co2ratingRecord = part2recursion(matrix, true).head.mkString
    java.lang.Long.parseLong(o2ratingRecord, 2) * java.lang.Long
      .parseLong(co2ratingRecord, 2)
  }

}
