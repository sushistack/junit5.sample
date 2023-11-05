package com.sushistack

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path

fun main() {
    println("Hello World!")
}

fun isPalindrome(input: String): Boolean {
    val sanitizedInput = input.replace(Regex("[^A-Za-z0-9]"), "").lowercase()
    return sanitizedInput == sanitizedInput.reversed()
}


class ListWriter(private val file: Path) {
    @Throws(IOException::class)
    fun write(vararg items: String?) {
        Files.write(file, listOf(java.lang.String.join(",", *items)))
    }
}