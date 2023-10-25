import com.sushistack.isPalindrome
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit
import java.util.stream.IntStream


class ParameterizedTestDemo {

    @ParameterizedTest
    @ValueSource(strings = ["racecar", "radar", "able was I ere I saw elba"])
    fun palindromes(candidate: String) {
        assertTrue(isPalindrome(candidate))
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = [" ", "   ", "\t", "\n"])
    fun nullEmptyAndBlankStrings(text: String?) {
        assertTrue(text == null || text.trim { it <= ' ' }.isEmpty())
    }

    @ParameterizedTest
    @EnumSource(ChronoUnit::class)
    fun testWithEnumSource(unit: TemporalUnit?) {
        assertNotNull(unit)
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    fun testWithExplicitLocalMethodSource(argument: String) {
        assertNotNull(argument)
    }

    @ParameterizedTest
    @MethodSource("range")
    fun testWithRangeMethodSource(argument: Int) {
        assertNotEquals(9, argument)
    }

    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    fun testWithMultiArgMethodSource(str: String, num: Int, list: List<String>) {
        assertEquals(5, str.length)
        assertTrue(num in 1..2)
        assertEquals(2, list.size)
    }

    companion object {
        @JvmStatic
        fun stringProvider() = listOf("apple", "banana")

        @JvmStatic
        fun range() = IntStream.range(0, 20).skip(10)

        @JvmStatic
        fun stringIntAndListProvider() = listOf(
            arguments("apple", 1, listOf("a", "b")),
            arguments("lemon", 2, listOf("x", "y"))
        )
    }

}