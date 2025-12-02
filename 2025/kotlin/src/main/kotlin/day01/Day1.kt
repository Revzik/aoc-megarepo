package day01

import util.readFile

fun run() {
    val input = readFile("input/day01.txt")

    println("Part 1 result: ${part1(input)}")
    println("Part 2 result: ${part2(input)}")
}

fun part1(input: List<String>): UInt {
    var result = 0u
    var current = 50

    for (move in input) {
        current += extractValue(move.trim())

        val turns = current / 100
        current += -turns * 100

        if (current < 0) {
            current += 100
        }

        if (current == 0) result++
    }

    return result
}

fun part2(input: List<String>): UInt {
    var result = 0u
    var current = 50

    for (move in input) {
        // This scenario doesn't count the following corner case:
        // If the dial is at a positive number X and we have a move LX
        // So if we have result = 55, we receive move = L55, then the dial will point at 0, but not count it as a pass through 0

        // I think it would be the best to check for 2 situations
        //   a. if we land on a 0
        //   b. how many whole turns have been made
        // Corner cases:
        //   1. result = 55, move = L55, dial = 0 - counted 1 by a.
        //   2. result = 50, move = R300, dial = 50 - counted 3 by b.
        //   3. result = 50, move = R550, dial = 0 - counted 1 by a. 5 by b.
        //   4. result = 50, move = L550, dial = 0 - counted 1 by a. 5 by b.

        // I need a test framework for this project...

        current += extractValue(move.trim())

        while (current < 0) {
            current += 100
            result++
        }
        while (current > 99) {
            current -= 100
            result++
        }

    }

    return result
}

fun extractValue(move: String): Int =
    if (move.startsWith('R')) move.substring(1).toInt()
    else -move.substring(1).toInt()
