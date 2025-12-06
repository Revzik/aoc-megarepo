package day05

import util.readFile

fun run() {
    val input = parseInput(readFile("input/day05.txt"))

    println("Part 1 result: ${countFreshIngredients(input)}")
    println("Part 2 result: ${countPossibleFreshIngredients(input)}")
}

data class IngredientList(val freshIdRanges: List<IdRange>, val ingredientIds: List<Long>)

data class IdRange(val low: Long, val high: Long) {
    companion object {
        fun of(range: String): IdRange {
            val splitRange = range.split('-').map { s -> s.toLong() }
            return IdRange(splitRange[0], splitRange[1])
        }
    }
}

fun parseInput(input: List<String>): IngredientList {
    val emptyLineIndex = input.indexOf("")
    return IngredientList(
        input.subList(0, emptyLineIndex).map { s -> IdRange.of(s) },
        input.subList(emptyLineIndex + 1, input.size).map { s -> s.toLong() }
    )
}

fun countFreshIngredients(input: IngredientList): Int {
    val mergedRanges = mergeOverlappingRanges(input.freshIdRanges)
    return input.ingredientIds.count { i -> isInAnyRange(i, mergedRanges) }
}

fun countPossibleFreshIngredients(input: IngredientList) = mergeOverlappingRanges(input.freshIdRanges)
    .map { range -> range.high - range.low + 1 }
    .reduce { acc, rangeCount -> acc + rangeCount }

fun mergeOverlappingRanges(input: List<IdRange>): List<IdRange> {
    // here we want the longest ranges with the lowest ID first, it'll make merging ranges a bit quicker
    val sortedRanges = input.sortedByDescending { it.high }.sortedBy { it.low }
    return mergeRecursive(sortedRanges, input)
}

fun mergeRecursive(input: List<IdRange>, previousInput: List<IdRange>): List<IdRange> {
    val output = mutableListOf(input[0])
    var lastRangeId = 0

    // since the first range is the base of our merged list, which we will compare against, start with 1
    for (inputId in 1..<input.size) {
        val checkedRange = input[inputId]
        val mergedRange = output[lastRangeId]

        // if ranges are overlapping, we extend the base range and continue checking next ones
        // if not we will start merging next ones to the checkedRange
        if (areRangesOverlapping(checkedRange, mergedRange)) {
            output[lastRangeId] = mergeRanges(checkedRange, mergedRange)
        } else {
            output.addLast(checkedRange)
            lastRangeId++
        }
    }

    // if the ranges were not changed by the process, then there is no more overlaps
    // otherwise, keep merging
    if (previousInput == output) {
        return output
    }

    return mergeRecursive(output, input)
}

fun areRangesOverlapping(a: IdRange, b: IdRange): Boolean {
    // the +- 1 are because if ranges are consecutive (e.g. 1-3, 4-5), they can be connected

    // first one for range a larger than b
    if (a.low - 1 <= b.high && a.high >= b.high) return true
    if (a.high + 1 >= b.low && a.low <= b.low) return true

    // second one for range b larger than a
    if (b.low - 1 <= a.high && b.high >= a.high) return true
    if (b.high + 1 >= a.low && b.low <= a.low) return true

    return false
}

fun mergeRanges(a: IdRange, b: IdRange): IdRange {
    val low = if (a.low < b.low) a.low else b.low
    val high = if (a.high > b.high) a.high else b.high
    return IdRange(low, high)
}

fun isInAnyRange(id: Long, idRanges: List<IdRange>) = idRanges.any { range -> id >= range.low && id <= range.high }
