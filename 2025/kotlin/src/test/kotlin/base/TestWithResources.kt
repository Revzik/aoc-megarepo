package base

import util.readExtendedMap
import util.readFile
import java.io.File
import kotlin.test.assertNotNull

open class TestWithResources {
    fun readResourceFile(path: String) = readFile(getAbsolutePath(path))

    fun readResourceExtendedMap(path: String, emptySpace: Char) = readExtendedMap(getAbsolutePath(path), emptySpace)

    fun getAbsolutePath(resourcePath: String): String {
        val resourceUrl = this::class.java.classLoader.getResource(resourcePath)
        assertNotNull(resourceUrl)
        return File(resourceUrl.toURI()).absolutePath
    }
}