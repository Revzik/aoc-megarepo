package day03

fun run() {
    val input = util.readFile("input/day03.txt")

    println("Part 1 result: ${findMaxPower(input, 2)}")
    println("Part 2 result: ${findMaxPower(input, 12)}")
}

fun findMaxPower(input: List<String>, batteryCount: Int): Long {
    var result = 0L

    // 1. find the biggest first index in the line that comes 12 digits before last one
    // 2. find the biggest second index in the line that comes 11 digits between previous and last one
    // 3. find the biggest third index in the line that comes 10 digits between previous and last one
    // 4. etc.
    for (strBank in input) {
        val bank = convertBank(strBank)
        val maxIndexes = findHighestIndexes(bank, batteryCount)
        result += createCell(bank, maxIndexes)
    }

    return result
}

fun convertBank(bank: String): List<Int> {
    return bank.map { c -> c.digitToInt() }
}

fun findHighestIndexes(bank: List<Int>, amount: Int): List<Int> {
    // here we'll store all the indexes of batteries which compose the best bank
    // start with -1 since we need a starting value in the list
    // since we're adding 1 in the loop, we'll start with -1 so we don't skip any indexes
    val maxIndexes = mutableListOf(-1)
    var workingBank = bank

    for (i in 0..<amount) {
        // finding the biggest value in the batteries that come after the last found
        // it'll mess up the indexing, so we add the last index + 1 (hence -1 in the starting value)
        val maxIndex = findHighestFirstIdx(workingBank, amount - i - 1)
        maxIndexes.addLast(maxIndex + maxIndexes.last() + 1)

        // trim off already processed batteries, so they're not counted
        workingBank = bank.subList(maxIndexes.last() + 1, bank.size)
    }

    return maxIndexes.subList(1, maxIndexes.size)
}

fun findHighestFirstIdx(bank: List<Int>, upToIdx: Int = 1): Int {
    // for bank 123456789 find the highest from 12345678,
    // since we can't make a battery if we select the last digit as first value
    val possibleBatteries = bank.subList(0, bank.size - upToIdx)
    return bank.indexOf(possibleBatteries.max())
}

fun createCell(bank: List<Int>, maxIndexes: List<Int>) = maxIndexes
    .map { idx -> bank[idx].toLong() }
    .reduce { acc, value -> acc * 10 + value }
