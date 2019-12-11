package main.kotlin.aoc.day01

import main.kotlin.aoc.readLines


fun main() {
    val input = readLines("src/main/kotlin/aoc/day01/Input.txt")

    part1(input)
    part2(input)
}

fun part1(input: List<String>) {
    println(calculateFuel(12))
    println(calculateFuel(14))
    println(calculateFuel(1969))
    println(calculateFuel(100756))

    val sum = input.map { calculateFuel(it.toInt()) }.sum()

    println("Part 1: " + sum)
}

fun part2(input: List<String>) {
    println(recursion(14))
    println(recursion(1969))
    println(recursion(100756))

    val sum = input.map { recursion(it.toInt()) }.sum()

    println("Part 2: " + sum)
}

fun calculateFuel(mass: Int): Int = mass / 3 - 2

fun recursion(n: Int): Int =
    if (calculateFuel(n) <= 0) 0 else calculateFuel(n) + recursion(calculateFuel(n))