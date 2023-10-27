
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ExternalMethodSourceDemo {
    @ParameterizedTest
    @MethodSource("StringsProviders#tinyStrings")
    fun testWithExternalMethodSource(tinyString: String?) {
        // test with tiny string
    }
}

internal object StringsProviders {
    @JvmStatic
    fun tinyStrings() = listOf(".", "oo", "OOO")
}