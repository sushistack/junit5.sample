package samples.dynamic

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class DynamicTestsDemo {
    // 동적으로 테스트를 만듬
    @TestFactory
    fun dynamicTestsExample(): List<DynamicTest> {
        return listOf(
            dynamicTest("Test 1: positive number") { assertTrue(isPositive(1)) },
            dynamicTest("Test 2: negative number") { assertFalse(isPositive(-1)) },
            dynamicTest("Test 3: zero") { assertFalse(isPositive(0)) }
        )
    }

    private fun isPositive(number: Int): Boolean {
        return number > 0
    }
}