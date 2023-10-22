import com.sushistack.isPalindrome
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit


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
}