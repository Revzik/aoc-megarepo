package day05

import base.TestWithResources
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day05Test : TestWithResources() {

    val testInput = readResourceFile("input/day05.txt")
    val testAnswers = readResourceFile("answers/day05.txt").map { s -> s.trim().toLong() }

    @Test
    fun `counts fresh ingredients correctly`() {
        assertEquals(testAnswers[0].toInt(), countFreshIngredients(parseInput(testInput)))
    }

    @Test
    fun `counts all possible fresh ids correctly`() {
        assertEquals(testAnswers[1], countPossibleFreshIngredients(parseInput(testInput)))
    }

    @Test
    fun `correctly parses input`() {
        val input = listOf(
            "1-2",
            "3-5",
            "2-12",
            "",
            "3",
            "5"
        )

        val freshIds = listOf(
            IdRange(1, 2),
            IdRange(3, 5),
            IdRange(2, 12)
        )
        val ingredientIds = listOf(3L, 5L)
        val expectedOutput = IngredientList(freshIds, ingredientIds)

        assertEquals(expectedOutput, parseInput(input))
    }

    @Test
    fun `correctly merges overlapping ranges`() {
        val input = listOf(
            IdRange(4, 6),
            IdRange(9, 10),
            IdRange(1, 2),
            IdRange(9, 12),
            IdRange(5, 7)
        )

        val expected = listOf(
            IdRange(1, 2),
            IdRange(4, 7),
            IdRange(9, 12),
        )

        assertEquals(expected, mergeOverlappingRanges(input))
    }

    @Test
    fun `correctly checks range overlap`() {
        assertTrue { areRangesOverlapping(IdRange(2, 6), IdRange(7, 9)) }
        assertTrue { areRangesOverlapping(IdRange(5, 8), IdRange(1, 5)) }
        assertTrue { areRangesOverlapping(IdRange(1, 8), IdRange(3, 7)) }
        assertTrue { areRangesOverlapping(IdRange(4, 7), IdRange(2, 7)) }
        assertTrue { areRangesOverlapping(IdRange(1, 2), IdRange(3, 4)) }
        assertTrue { areRangesOverlapping(IdRange(1, 1), IdRange(1, 1)) }
        assertTrue { areRangesOverlapping(IdRange(5, 6), IdRange(1, 10)) }

        assertFalse { areRangesOverlapping(IdRange(1, 2), IdRange(4, 5)) }
        assertFalse { areRangesOverlapping(IdRange(9, 12), IdRange(1, 6)) }
    }
}