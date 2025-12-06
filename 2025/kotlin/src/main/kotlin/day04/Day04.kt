package day04

const val roll = '@'

fun run () {
    val input = util.readExtendedMap("input/day04.txt", '.')

    println("Day 4: Printing Department")
    println("Part 1 result: ${countAccessibleRolls(input)}")
    println("Part 2 result: ${countRemovableRolls(input)}")
}

fun countAccessibleRolls(map: Array<CharArray>): Int {
    var result = 0

    for (y in 1..< map.size - 1) {
        for (x in 1..< map[0].size - 1) {
            if (map[y][x] != roll) {
                continue
            }

            if (countSurroundingRolls(map, x, y) < 4) {
                result++
            }
        }
    }

    return result
}

fun countRemovableRolls(map: Array<CharArray>): Int {
    var result = 0
    var previousResult = -1

    // if there is no more rolls to remove then the previous result will be the same as current
    while (result != previousResult) {
        previousResult = result

        for (y in 1..<map.size - 1) {
            for (x in 1..<map[0].size - 1) {
                if (map[y][x] != roll) {
                    continue
                }

                // I know this messes up the order in which rolls are removed, but it doesn't matter in this case
                if (countSurroundingRolls(map, x, y) < 4) {
                    map[y][x] = 'x'
                    result++
                }
            }
        }
    }

    return result
}

fun countSurroundingRolls(map: Array<CharArray>, x: Int, y: Int): Int {
    var amount = 0

    if (map[y - 1][x - 1] == roll) amount++
    if (map[y - 1][x] == roll) amount++
    if (map[y - 1][x + 1] == roll) amount++
    if (map[y][x - 1] == roll) amount++
    if (map[y][x + 1] == roll) amount++
    if (map[y + 1][x - 1] == roll) amount++
    if (map[y + 1][x] == roll) amount++
    if (map[y + 1][x + 1] == roll) amount++

    return amount
}