package day02

fun run() {
    val input = util.readFile("input/day02.txt")[0].split(",")

    println("Part 1 result: ${part1(input)}")
    println("Part 2 result: ${part2(input)}")
}

fun part1(input: List<String>): Long {
    var result = 0L

    for (range in input) {
        val parsedRange = range.split("-").map { s -> s.toLong() }
        val start = parsedRange[0]
        val end = parsedRange[1]

        // brute force-ish - go through all ids in the range
        for (id in start..end) {
            if (checkInvalidPart1(id)) result += id
        }
    }

    return result
}

fun checkInvalidPart1(id: Long): Boolean {
    val strId = id.toString()
    // only even length can have the same first and last parts
    if (strId.length % 2 == 1) {
        return false
    }

    val half = strId.length / 2
    return (strId.take(half) == strId.takeLast(half))
}

fun part2(input: List<String>): Long {
    var result = 0L

    for (range in input) {
        val parsedRange = range.split("-").map { s -> s.toLong() }
        val start = parsedRange[0]
        val end = parsedRange[1]

        // brute force-ish - go through all ids in the range
        for (id in start..end) {
            if (checkInvalidPart2(id)) result += id
        }
    }

    return result
}

fun checkInvalidPart2(id: Long): Boolean {
    val strId = id.toString()
    // we only need to check patterns up to half of the ID length, since there can't be any longer
    for (interval in 1..strId.length / 2) {
        // exclude any intervals which will not fit a whole pattern
        if (strId.length % interval != 0) {
            continue
        }

        // if there is only single element in the set, it means all analyzed substrings are the same
        if (extractPatterns(strId, interval).count() == 1) return true
    }

    return false
}

fun extractPatterns(id: String, interval: Int): Set<String> {
    val uniquePatterns: MutableSet<String> = mutableSetOf()

    // simply go through equal length of the ID substrings and add them to a set, it'll pick any non-repeating
    for (i in 0..<id.length step interval) {
        uniquePatterns.add(id.substring(i, i+interval))
    }

    return uniquePatterns
}