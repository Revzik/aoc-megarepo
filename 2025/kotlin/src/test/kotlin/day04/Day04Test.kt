package day04

import base.TestWithResources
import kotlin.test.Test
import kotlin.test.assertEquals

class Day04Test : TestWithResources() {

    val testMap = readResourceExtendedMap("input/day04.txt", '.')
    val testAnswers = readResourceFile("answers/day04.txt").map { s -> s.trim().toInt() }

    @Test
    fun `counts accessible rolls properly`() {
        assertEquals(testAnswers[0], countAccessibleRolls(testMap))
    }

    @Test
    fun `counts removable rolls properly`() {
        assertEquals(testAnswers[1], countRemovableRolls(testMap))
    }
}