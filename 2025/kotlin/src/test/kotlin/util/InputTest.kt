package util

import java.io.File
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class InputTest {

    val mapPath = getAbsolutePath("input/mapInput.txt")

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

    fun getAbsolutePath(resourcePath: String): String {
        val resourceUrl = this::class.java.classLoader.getResource(resourcePath)
        assertNotNull(resourceUrl)
        return File(resourceUrl.toURI()).absolutePath
    }
}
