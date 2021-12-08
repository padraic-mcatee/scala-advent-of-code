package com.pmcatee.aoc2021

import com.pmcatee.aoclib.Day

object Day1 extends Day(2021, 1) {

  val depths = input.map(_.toInt)

  override val part1 = depths.zip(depths.tail).count({ case (a, b) => a < b })

  val slide3 = depths.sliding(3).map(_.sum).toList

  override val part2 = slide3.zip(slide3.tail).count({ case (a, b) => a < b })

}
