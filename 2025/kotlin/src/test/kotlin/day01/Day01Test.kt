package day01

import base.TestWithResources
import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test : TestWithResources() {

    val testData = readResourceFile("input/day01.txt")
    val testAnswers = readResourceFile("answers/day01.txt").map { s -> s.trim().toUInt() }

    val troublesomeData = """
        R48
        R50
        L239
        R20
        R34
        L63
        R91
    """.trimIndent().split("\n")

    @Test
    fun part1Test() {
        assertEquals(testAnswers[0], part1(testData))
    }

    @Test
    fun part2Test() {
        assertEquals(testAnswers[1], part2(testData))
        assertEquals(4u, part2(troublesomeData))
    }
}