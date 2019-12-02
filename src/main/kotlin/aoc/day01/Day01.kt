package main.kotlin.aoc.day01

import java.io.File

fun main(args: Array<String>) {
    part1()
    part2()
}

fun part1() {
    println(calculateFuel(12))
    println(calculateFuel(14))
    println(calculateFuel(1969))
    println(calculateFuel(100756))

    val sum = getInput().map { calculateFuel(it.toInt()) }.sum()

    println("Part 1: " + sum)
}

fun part2() {
    println(recursion(14))
    println(recursion(1969))
    println(recursion(100756))

    val sum = getInput().map { recursion(it.toInt()) }.sum()

    println("Part 2: " + sum)
}

fun calculateFuel(mass: Int): Int = mass / 3 - 2

fun recursion(n: Int): Int =
    if (calculateFuel(n) <= 0) 0 else calculateFuel(n) + recursion(calculateFuel(n))

fun getInput(): List<String> = File("src/main/kotlin/aoc/day01/Input.txt").readLines()