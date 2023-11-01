package samples.dynamic

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DynamicContainer.dynamicContainer
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class DynamicNodeDemo {
    @TestFactory
    fun dynamicTestsWithContainers() = listOf(
        dynamicContainer("Container 1", listOf(
            dynamicTest("Test 1.1") { assertTrue(isEven(2)) },
            dynamicTest("Test 1.2") { assertTrue(isEven(4)) }
        )),
        dynamicContainer("Container 2", listOf(
            dynamicTest("Test 2.1") { assertTrue(isEven(6)) },
            dynamicContainer("Nested Container 2.2", listOf(
                dynamicTest("Test 2.2.1") { assertTrue(isEven(8)) },
                dynamicTest("Test 2.2.2") { assertTrue(isEven(10)) }
            ))
        ))
    )

    private fun isEven(number: Int): Boolean {
        return number % 2 == 0
    }
}