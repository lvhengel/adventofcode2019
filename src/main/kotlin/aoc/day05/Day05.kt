package main.kotlin.aoc.day05

import main.kotlin.aoc.readText

fun main() {
    val file = readText("src/main/kotlin/aoc/day05/Input.txt")
    println(processIntCode(file,1))
}

fun processIntCode(text: String, input: Int): MutableList<Int> {
    val list = text.split(",").map { it.toInt() }.toMutableList()

    var i = 0
    var halt = false

    while (!halt) {

        val instruction = list[i].toString().padStart(5, '0')
        val oppCode = getOppCode(instruction)
        val parameters = getParameters(instruction)

        val firstParameter = parameters.get(2)
        val secondParameter = parameters.get(1)
        val thirdParameter = parameters.get(0)

        if (oppCode === 1) {
            val subList = list.subList(i, i + 4)
            var first: Int
            val second: Int
            if (firstParameter === '0') {
                first = list[subList[1]]
            } else {
                first = subList[1]
            }
            if (secondParameter === '0') {
                second = list[subList[2]]
            } else {
                second = subList[2]
            }
            if (thirdParameter === '0') {
                list[subList[3]] = first + second
            } else {
                subList[3] = first + second
            }
            i += 4
        } else if (oppCode === 2) {
            val subList = list.subList(i, i + 4)
            var first: Int
            val second: Int
            if (firstParameter === '0') {
                first = list[subList[1]]
            } else {
                first = subList[1]
            }
            if (secondParameter === '0') {
                second = list[subList[2]]
            } else {
                second = subList[2]
            }
            if (thirdParameter === '0') {
                list[subList[3]] = first * second
            } else {
                subList[3] = first * second
            }
            i += 4
        } else if (oppCode === 3) {
            if (firstParameter === '0') {
                list[list[i + 1]] = input
            } else {
                list[i + 1] = input
            }
            i += 2
        } else if (oppCode === 4) {
            val value = list[i + 1]
            if (firstParameter === '0') {
                println(list[list[i + 1]])
            } else {
                println(list[i + 1])
            }
            i += 2
        } else if (oppCode === 99) {
            halt = true
        }
    }
    return list
}

fun getOppCode(instruction: String): Int {
    return instruction.takeLast(2).toInt()
}

fun getParameters(instruction: String): String {
    return instruction.take(3)
}