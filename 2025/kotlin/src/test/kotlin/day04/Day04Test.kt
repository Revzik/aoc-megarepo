package day04

import base.TestWithResources
import kotlin.test.Test
import kotlin.test.assertEquals

class Day04Test : TestWithResources() {

    val testMap = readResourceExtendedMap("input/day04.txt", '.')

    @Test
    fun `counts accessible rolls properly`() {
        assertEquals(13, countAccessibleRolls(testMap))
    }

    @Test
    fun `counts removable rolls properly`() {
        assertEquals(43, countRemovableRolls(testMap))
    }
}