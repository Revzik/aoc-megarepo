package day02

import base.TestWithResources
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day02Test : TestWithResources() {

    val testData = readResourceFile("input/day02.txt")[0]
    val testAnswers = readResourceFile("answers/day02.txt").map { s -> s.trim().toLong() }

    @Test
    fun part1Test() {
        assertEquals(testAnswers[0], part1(testData.split(',')))
    }

    @Test
    fun checkInvalidPart1Test() {
        assertFalse { checkInvalidPart1(123L) }
        assertFalse { checkInvalidPart1(9989L) }
        assertTrue { checkInvalidPart1(9999L) }
        assertTrue { checkInvalidPart1(123456123456L) }
    }

    @Test
    fun part2Test() {
        assertEquals(testAnswers[1], part2(testData.split(',')))
    }

    @Test
    fun checkInvalidPart2Test() {
        assertFalse { checkInvalidPart2(123L) }
        assertFalse { checkInvalidPart2(123412L) }
        assertTrue { checkInvalidPart2(9999L) }
        assertTrue { checkInvalidPart2(123123123L) }
    }
}