package day03

import base.TestWithResources
import kotlin.test.Test
import kotlin.test.assertEquals

class Day03Test : TestWithResources() {
    val testData = readResourceFile("input/day03.txt")

    @Test
    fun part1Test() {
        assertEquals(357, findMaxPower(testData, 2))
    }

    @Test
    fun part2Test() {
        assertEquals(3121910778619, findMaxPower(testData, 12))
    }

    @Test
    fun findHighestFirstIdxTest() {
        assertEquals(7, findHighestFirstIdx(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)))
        assertEquals(0, findHighestFirstIdx(listOf(9, 8, 7, 6, 5, 4, 3, 2, 1)))
        assertEquals(0, findHighestFirstIdx(listOf(1, 1, 1, 1)))
        assertEquals(2, findHighestFirstIdx(listOf(1, 1, 4, 4)))
    }

    @Test
    fun findHighestIndexesTest() {
        assertEquals(listOf(0, 2, 4), findHighestIndexes(listOf(9, 5, 9, 4, 8), 3))
    }

    @Test
    fun createCellTest() {
        assertEquals(434234234278, createCell(convertBank("234234234234278"), listOf(2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)))
    }
}