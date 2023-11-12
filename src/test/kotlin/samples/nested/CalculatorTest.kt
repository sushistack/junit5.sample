package samples.nested

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Calculator 테스트")
internal class CalculatorTest {
    var calculator: Calculator = Calculator()

    @Nested
    @DisplayName("덧셈 기능 테스트")
    internal inner class AddTests {
        @Test
        @DisplayName("두 양수의 덧셈")
        fun testAddTwoPositiveNumbers() {
            assertEquals(5, calculator.add(2, 3), "2 + 3은 5이어야 합니다.")
        }

        @Test
        @DisplayName("음수와 양수의 덧셈")
        fun testAddNegativeAndPositiveNumber() {
            assertEquals(1, calculator.add(-2, 3), "-2 + 3은 1이어야 합니다.")
        }
    }

    @Nested
    @DisplayName("뺄셈 기능 테스트")
    internal inner class SubtractTests {
        @Test
        @DisplayName("두 양수의 뺄셈")
        fun testSubtractTwoPositiveNumbers() {
            assertEquals(1, calculator.subtract(3, 2), "3 - 2는 1이어야 합니다.")
        }

        @Test
        @DisplayName("양수와 음수의 뺄셈")
        fun testSubtractPositiveAndNegativeNumber() {
            assertEquals(5, calculator.subtract(3, -2), "3 - (-2)는 5이어야 합니다.")
        }
    }
}

// 간단한 Calculator 클래스 예제
internal class Calculator {
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun subtract(a: Int, b: Int): Int {
        return a - b
    }
}