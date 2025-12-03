package day02

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day02Test {
    val testData1 = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"

    @Test
    fun part1Test() {
        assertEquals(1227775554L, part1(testData1.split(',')))
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
        assertEquals(4174379265L, part2(testData1.split(',')))
    }

    @Test
    fun checkInvalidPart2Test() {
        assertFalse { checkInvalidPart2(123L) }
        assertFalse { checkInvalidPart2(123412L) }
        assertTrue { checkInvalidPart2(9999L) }
        assertTrue { checkInvalidPart2(123123123L) }
    }
}