package com.sushistack

fun main() {
    println("Hello World!")
}

fun isPalindrome(input: String): Boolean {
    val sanitizedInput = input.replace(Regex("[^A-Za-z0-9]"), "").lowercase()
    return sanitizedInput == sanitizedInput.reversed()
}