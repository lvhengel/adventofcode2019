package main.kotlin.aoc.day04

fun main(args: Array<String>) {
    part1()
    part2()
}

fun part1() {
    println(checkPassword("223450"))
    var counter = 0
    for (i in 125730..579381) {
        if (checkPassword(i.toString())) {
            counter++
        }
    }
    println(counter)
}

fun part2() {
    println(checkPassword2("112233"))
    println(checkPassword2("123444"))
    println(checkPassword2("111122"))
    var counter = 0
    for (i in 125730..579381) {
        if (checkPassword2(i.toString())) {
            counter++
        }
    }
    println(counter)
}

fun checkPassword(password: String): Boolean {
    return length(password) && twoadjacent(password) && neverdecrease(password)
}

fun checkPassword2(password: String): Boolean {
    return length(password) && onlytwoadjacent(password) && neverdecrease(password)
}

fun length(password: String): Boolean = password.length === 6

fun twoadjacent(password: String): Boolean {
    var previous = '0' // use 0 as previous start because it is not used in the range as start
    password.forEach {
        if (it.equals(previous)) {
            return true
        }
        previous = it
    }
    return false
}

fun onlytwoadjacent(password: String): Boolean {
    var previous = '0' // use 0 as previous start because it is not used in the range as start
    var hashMap: HashMap<Char, Int> = HashMap<Char, Int>()
    password.forEach {
        var count = hashMap.get(it)
        if (count != null) {
            hashMap.put(it, ++count)
        } else {
            hashMap.put(it, 1)
        }
        previous = it
    }
    return hashMap.containsValue(2)
}

fun neverdecrease(password: String): Boolean {
    var previous = 0 // use 0 as previous start because it is not used in the range as start
    password.forEach {
        if (it.toInt() < previous) {
            return false
        }
        previous = it.toInt()
    }
    return true
}