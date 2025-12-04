package day04

import kotlin.test.Test
import kotlin.test.assertEquals

class Day04Test {

    val testMap = arrayOf(
        "............".toCharArray(),
        "...@@.@@@@..".toCharArray(),
        ".@@@.@.@.@@.".toCharArray(),
        ".@@@@@.@.@@.".toCharArray(),
        ".@.@@@@..@..".toCharArray(),
        ".@@.@@@@.@@.".toCharArray(),
        "..@@@@@@@.@.".toCharArray(),
        "..@.@.@.@@@.".toCharArray(),
        ".@.@@@.@@@@.".toCharArray(),
        "..@@@@@@@@..".toCharArray(),
        ".@.@.@@@.@..".toCharArray(),
        "............".toCharArray()
    )

    @Test
    fun `counts accessible rolls properly`() {
        assertEquals(13, countAccessibleRolls(testMap))
    }

    @Test
    fun `counts removable rolls properly`() {
        assertEquals(43, countRemovableRolls(testMap))
    }
}