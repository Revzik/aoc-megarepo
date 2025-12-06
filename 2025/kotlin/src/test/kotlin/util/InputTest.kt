package util

import base.TestWithResources
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class InputTest : TestWithResources() {

    val mapPath = getAbsolutePath("mapInput.txt")

    @Test
    fun `can read file as 2D array`() {
        val expected = arrayOf(
            ".xxx.xxx.x".toCharArray(),
            "xx.x.xx.xx".toCharArray(),
            ".xxx.x.x..".toCharArray(),
            "..x.x..xxx".toCharArray(),
            ".x.x.xxx.x".toCharArray()
        )
        val actual = readMap(mapPath)

        assertEquals(expected.size, actual.size)
        expected.forEachIndexed { index, arr -> assertContentEquals(arr, actual[index]) }
    }

    @Test
    fun `can read file as 2D array extended with empty space`() {
        val expected = arrayOf(
            "............".toCharArray(),
            "..xxx.xxx.x.".toCharArray(),
            ".xx.x.xx.xx.".toCharArray(),
            "..xxx.x.x...".toCharArray(),
            "...x.x..xxx.".toCharArray(),
            "..x.x.xxx.x.".toCharArray(),
            "............".toCharArray()
        )
        val actual = readExtendedMap(mapPath, '.')

        assertEquals(expected.size, actual.size)
        expected.forEachIndexed { index, arr -> assertContentEquals(arr, actual[index]) }
    }
}
