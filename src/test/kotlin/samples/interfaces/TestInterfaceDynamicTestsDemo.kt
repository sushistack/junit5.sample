package samples.interfaces
import com.sushistack.isPalindrome
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import java.util.stream.Stream

interface TestInterfaceDynamicTestsDemo {
    @TestFactory
    fun dynamicTestsForPalindromes(): Stream<DynamicTest> {
        return Stream.of("racecar", "radar", "mom", "dad")
            .map { text -> dynamicTest(text) { assertTrue(isPalindrome(text)) } }
    }
}