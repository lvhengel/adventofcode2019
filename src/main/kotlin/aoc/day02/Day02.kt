package main.kotlin.aoc.day02

import main.kotlin.aoc.readText

fun main() {
    part1()
    part2()
}

fun part1() {
    println(processIntCode(12,2))
}

fun part2() {
    for (i in 0..99) {
        for (j in 0..99) {
            var result = processIntCode(i,j)
            if (result === 19690720) {
                println(100 * i + j)
            }
        }
    }
}

fun processIntCode(noun: Int, verb: Int): Int {
    val input = readText("src/main/kotlin/aoc/day02/Input.txt").split(",").map { it.toInt() }.toMutableList()

    // Change starting values
    input[1] = noun
    input[2] = verb

    var i = 0
    var halt = false

    while (!halt) {

        val subList = input.subList(i,i+4)
        val oppCode = subList[0]

        if (oppCode.toInt() === 1) {
            input[subList[3]] = input[subList[1]] + input[subList[2]]
        } else if (oppCode.toInt() === 2) {
            input[subList[3]] = input[subList[1]] * input[subList[2]]
        } else if (oppCode.toInt() === 99) {
            halt = true
        }
        i += 4
    }
    return input[0]
}