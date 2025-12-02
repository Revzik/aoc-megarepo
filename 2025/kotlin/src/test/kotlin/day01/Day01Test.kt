package day01

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day01Test {
    val testData1 = """
        L68
        L30
        R48
        L5
        R60
        L55
        L1
        L99
        R14
        L82 
        """.trimIndent().split("\n")

//    Wrong scenario for part 2 from log analysis:
//    R50, CB: 98, RB: 51, CA: 48, RA: 52
//    L239, CB: 48, RB: 52, CA: 109, RA: 55
//    R20, CB: 109, RB: 55, CA: 29, RA: 56
//    R34, CB: 29, RB: 56, CA: 63, RA: 56
//    L63, CB: 63, RB: 56, CA: 0, RA: 57
//    R91, CB: 0, RB: 57, CA: 91, RA: 57
    val testData2 = """
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
        assertEquals(3u, part1(testData1))
    }

    @Test
    fun part2Test() {
        assertEquals(6u, part2(testData1))
        assertEquals(4u, part2(testData2))
    }
}