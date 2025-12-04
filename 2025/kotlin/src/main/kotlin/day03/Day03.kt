package day03

fun run() {
    val input = util.readFile("input/day03.txt")

    println("Part 1 result: ${part1(input)}")
    println("Part 2 result: ${part2(input)}")
}

fun part1(input: List<String>): Int {
    var result = 0

    for (strBank in input) {
        val bank = convertBank(strBank)
        val maxIdx = findHighestFirstIdx(bank)
        val firstMax = bank[maxIdx]
        val secondMax = findHighestSecond(bank, maxIdx)
        result += firstMax * 10 + secondMax
    }

    return result
}

fun part2(input: List<String>): Long {
    var result = 0L

    // here it'll be pretty much the same:
    // 1. find the biggest first index in the line that comes 12 digits before last one
    // 2. find the biggest second index in the line that comes 11 digits between previous and last one
    // 3. find the biggest third index in the line that comes 10 digits between previous and last one
    // 4. etc.
    for (strBank in input) {
        val bank = convertBank(strBank)
        val maxIndexes = findHighestIndexes(bank)
        result += createCell(bank, maxIndexes)
    }

    return result
}

fun convertBank(bank: String): List<Int> {
    return bank.map { c -> c.digitToInt() }
}

fun findHighestFirstIdx(bank: List<Int>, upToIdx: Int = 1): Int {
    // for bank 123456789 find the highest from 12345678,
    // since we can't make a battery if we select the last digit as first value
    val possibleBatteries = bank.subList(0, bank.size - upToIdx)
    return bank.indexOf(possibleBatteries.max())
}

fun findHighestSecond(bank: List<Int>, idxToIgnore: Int): Int {
    // here we'll remove the elements before index from previous search and find the largest value
    // we want to search only for numbers appearing after the previously found value
    return bank.subList(idxToIgnore + 1, bank.size).max()
}

fun findHighestIndexes(bank: List<Int>, amount: Int = 12): List<Int> {
    val maxIndexes = mutableListOf(-1)
    var workingBank = bank

    for (i in 0..<amount) {
        val maxIndex = findHighestFirstIdx(workingBank, amount - i - 1)
        maxIndexes.addLast(maxIndex + maxIndexes.last() + 1)
        workingBank = bank.subList(maxIndexes.last() + 1, bank.size)
    }

    return maxIndexes.subList(1, maxIndexes.size)
}

fun createCell(bank: List<Int>, maxIndexes: List<Int>): Long {
    val batteries = maxIndexes.map { idx -> bank[idx] }
    return consolidateBatteries(batteries)
}

// can it be rewritten into reduce ??
fun consolidateBatteries(batteries: List<Int>): Long {
    var power = 0L
    var multiplier = 1L
    for (battery in batteries.reversed()) {
        power += multiplier * battery
        multiplier *= 10
    }
    return power
}