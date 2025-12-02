package day01

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day01Test {
    val testData = """
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

    @Test
    fun part1Test() {
        assertEquals(3u, part1(testData))
    }

    @Test
    fun part2Test() {
        assertEquals(6u, part2(testData))
    }
}