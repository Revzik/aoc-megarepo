package util

import java.io.File

fun readFile(path: String): List<String> = File(path).useLines { it.toList() }