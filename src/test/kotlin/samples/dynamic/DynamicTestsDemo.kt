package samples.dynamic

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import java.io.File

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

    @TestFactory
    fun testStringLengths(): List<DynamicTest> {
        val jsonContent = File("src/test/resources/stringLengthTestCases.json").readText()
        val testCases: List<TestCase> = Json.decodeFromString(jsonContent)

        return testCases.map { testCase ->
            dynamicTest("String '${testCase.input}' should have length ${testCase.expectedLength}") {
                val actualLength = testCase.input.length
                assertEquals(testCase.expectedLength, actualLength) {
                    "Expected length ${testCase.expectedLength} but got $actualLength"
                }
            }
        }
    }

    @Serializable
    data class TestCase(val input: String, val expectedLength: Int)
}