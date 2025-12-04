package util

import java.io.File

fun readFile(path: String) = File(path)
    .useLines { it.toList() }

fun readMap(path: String) = readFile(path)
    .map { line -> line.toCharArray() }
    .toTypedArray()

fun readExtendedMap(path: String, emptySpace: Char): Array<CharArray> {
    val lines = readFile(path).toMutableList()

    val emptyRow = emptySpace.toString().repeat(lines[0].length)
    lines.addFirst(emptyRow)
    lines.addLast(emptyRow)

    return lines.map { line -> (emptySpace + line + emptySpace).toCharArray() }.toTypedArray()
}