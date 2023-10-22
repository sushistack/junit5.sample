import com.sushistack.isPalindrome
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ParameterizedTestDemo {

    @ParameterizedTest
    @ValueSource(strings = ["racecar", "radar", "able was I ere I saw elba"])
    fun palindromes(candidate: String) {
        assertTrue(isPalindrome(candidate))
    }
}