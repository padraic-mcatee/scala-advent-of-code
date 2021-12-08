package com.pmcatee.aoclib

import scala.util.Using

abstract class Day(val year: Int, val day: Int) {

  lazy val input =
    Using(io.Source.fromResource(s"aoc$year/day$day.txt"))(
      _.getLines.toList
    ).get

  val part1: Any
  val part2: Any

  def main(args: Array[String]) = {
    println(s"""|Advent of Code $year
                |Day $day Results
                |====================
                |part1: $part1
                |part2: $part2""".stripMargin)
  }
}
