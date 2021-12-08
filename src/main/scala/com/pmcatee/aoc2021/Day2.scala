package com.pmcatee.aoc2021

import com.pmcatee.aoclib.Day

object Day2 extends Day(2021, 2) {

  sealed abstract trait Direction
  case class Forward(distance: Int) extends Direction
  case class Up(distance: Int) extends Direction
  case class Down(distance: Int) extends Direction

  object Direction {
    def apply(d: String, l: Int) = d match {
      case "forward" => Forward(l)
      case "up"      => Up(l)
      case "down"    => Down(l)
    }
  }

  val directions =
    input.map(_.split(" ")).map(r => Direction(r(0), r(1).toInt))

  object Part1 {
    case class Pos(x: Int, y: Int) {
      def move(d: Direction) = d match {
        case Forward(distance) => Pos(x + distance, y)
        case Up(distance)      => Pos(x, y - distance)
        case Down(distance)    => Pos(x, y + distance)
      }
    }

    val finalPos = directions.foldLeft(Pos(0, 0))((b, x) => b.move(x))
  }

  object Part2 {
    case class Pos(x: Int, y: Int, a: Int) {
      def move(d: Direction) = d match {
        case Forward(distance) => Pos(x + distance, y + distance*a, a)
        case Up(distance)      => Pos(x, y, a - distance)
        case Down(distance)    => Pos(x, y, a + distance)
      }
    }

    val finalPos = directions.foldLeft(Pos(0, 0, 0))((b, x) => b.move(x))
  }

  override val part1: Any = Part1.finalPos.x * Part1.finalPos.y
  override val part2: Any = Part2.finalPos.x * Part2.finalPos.y
}
