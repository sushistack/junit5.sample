package com.sushistack

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import io.github.oshai.kotlinlogging.KotlinLogging

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

class MyAutoCloseableResource() : AutoCloseable {
    companion object {
        private val log = KotlinLogging.logger {}
    }

    init {
        log.info { "Resource opened." }
    }

    override fun close() {
        log.info { "Resource closed." }
    }

    fun doSomething() = "Doing something with the resource!"
}

class BankAccount(private var balance: Double) {

    init {
        require(balance >= 0) { "초기 잔액은 음수가 될 수 없습니다." }
    }

    fun deposit(amount: Double) {
        require(amount > 0) { "입금액은 양수여야 합니다." }
        balance += amount
    }

    fun withdraw(amount: Double) {
        require(amount > 0) { "출금액은 양수여야 합니다." }
        if (amount > balance) {
            throw IllegalStateException("잔액이 부족합니다.")
        }
        balance -= amount
    }

    fun getBalance(): Double = balance
}