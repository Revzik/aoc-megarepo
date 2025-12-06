package day01

import util.readFile

fun run() {
    val input = readFile("input/day01.txt")

    println("Day 1: Secret Entrance")
    println("Part 1 result: ${part1(input)}")
    println("Part 2 result: ${part2(input)}")
}

fun part1(input: List<String>): UInt {
    var result = 0u
    var current = 50

    for (move in input) {
        // extract the amount the knob needs to be turned
        // L255 -> -255
        // R4 -> 4
        current += extractValue(move.trim())

        // strip the hundreds, not needed in this case
        val turns = current / 100
        current += -turns * 100

        if (current < 0) {
            current += 100
        }

        // only interested when landing on 0
        if (current == 0) result++
    }

    return result
}

fun part2(input: List<String>): UInt {
    var result = 0u
    var current = 50

    for (move in input) {
        // in this case I needed slightly different logic for L and R turns, so extraction is a bit different
        val direction = move[0]
        val clicks = move.substring(1).trim().toInt()

        // each whole turn passes through 0 once
        // if we start from 0 and do a turn, we still want to count it once
        // so increment the result by amount of whole turns
        val turns = clicks / 100
        val rest = clicks - turns * 100
        result += turns.toUInt()

        if (direction == 'L') {
            if (current == 0) { // if we start from 0, we don't want to count LX as passing through 0
                current += 100
            } else if (rest > current) { // case for current = 40, move = L50, etc.
                result++
                current += 100
            } else if (rest == current) { // case for landing on 0
                result++
            }
            current -= rest
        } else {
            // right is simpler, all the cases from left are covered by this
            if (rest + current > 99) {
                result++
                current -= 100
            }
            current += rest
        }
    }

    return result
}

fun extractValue(move: String): Int =
    if (move.startsWith('R')) move.substring(1).toInt()
    else -move.substring(1).toInt()
