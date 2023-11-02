package samples.dynamic

import com.sushistack.isPalindrome
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Named.named
import org.junit.jupiter.api.TestFactory
import java.util.stream.Stream
import kotlin.test.assertTrue


class DynamicTestsNamedDemo {
    @TestFactory
    fun dynamicTestsFromStreamFactoryMethodWithNames(): Stream<DynamicTest> {
        // Stream of palindromes to check
        val inputStream = Stream.of(
            named("racecar is a palindrome", "racecar"),
            named("radar is also a palindrome", "radar"),
            named("mom also seems to be a palindrome", "mom"),
            named("dad is yet another palindrome", "dad")
        )

        // Returns a stream of dynamic tests.

        return DynamicTest.stream(inputStream) { text -> assertTrue(isPalindrome(text)) }
    }
}