package main.kotlin.aoc.day03

import java.io.File
import kotlin.math.abs

fun main(args: Array<String>) {
    part1()
    part2()
}

fun part1() {

    println(getManhattanDistance("R8,U5,L5,D3", "U7,R6,D4,L4"))
    println(getManhattanDistance("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83"))
    println(getManhattanDistance("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"))
    println(getManhattanDistance(getInput()[0], getInput()[1]))
}

fun part2() {
    println(getFewestSteps("R8,U5,L5,D3","U7,R6,D4,L4"))
    println(getFewestSteps(getInput()[0], getInput()[1]))
}

fun getManhattanDistance(line1: String, line2: String): Int {
    var path1 = getPath(line1.split(","))
    var path2 = getPath(line2.split(","))

    val min = path1.intersect(path2).minBy {
        abs(it.first) + abs(it.second)
    }

    return if (min != null) abs(min.first) + abs(min.second) else 0
}

fun getFewestSteps(line1: String, line2: String): Int? {
    var path1 = getPath(line1.split(","))
    var path2 = getPath(line2.split(","))

    val fewest = path1.intersect(path2).map {
        path1.indexOf(it) + 1 + path2.indexOf(it) + 1
    }.minBy {
        it
    }
    return fewest
}

fun getPath(input: List<String>): MutableList<Pair<Int, Int>> {
    var x = 0
    var y = 0
    var path = mutableListOf<Pair<Int, Int>>()
    input.forEach {
        val direction = it.get(0)
        val length = it.substring(1)

        for (i in 1..length.toInt()) {
            when {
                direction === 'U' -> {
                    y--
                }
                direction === 'D' -> {
                    y++
                }
                direction === 'R' -> {
                    x++
                }
                direction === 'L' -> {
                    x--
                }
            }
            path.add(Pair(x, y))
        }
    }
    return path
}

fun getInput(): List<String> = File("src/main/kotlin/aoc/day03/Input.txt").readLines()