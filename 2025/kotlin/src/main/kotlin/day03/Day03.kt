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

fun convertBank(bank: String): List<Int> {
    return bank.map { c -> c.digitToInt() }
}

fun findHighestFirstIdx(bank: List<Int>): Int {
    // for bank 123456789 find the highest from 12345678,
    // since we can't make a battery if we select the last digit as first value
    val max = bank.subList(0, bank.size - 1).max()
    return bank.indexOf(max)
}

fun findHighestSecond(bank: List<Int>, idxToIgnore: Int): Int {
    // here we'll remove the elements before index from previous search and find the largest value
    // we want to search only for numbers appearing after the previously found value
    return bank.subList(idxToIgnore + 1, bank.size).max()
}

fun part2(input: List<String>): Long {
    var result = 0L

    // here it'll be pretty much the same:
    // 1. find the biggest first index in the line that comes 12 digits before last one
    // 2. find the biggest second index in the line that comes 11 digits between previous and last one
    // 3. find the biggest third index in the line that comes 10 digits between previous and last one
    // 4. etc.


    return result
}
