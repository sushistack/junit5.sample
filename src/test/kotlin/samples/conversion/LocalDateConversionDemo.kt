package samples.conversion

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.JavaTimeConversionPattern
import org.junit.jupiter.params.provider.ValueSource
import java.time.LocalDate

class LocalDateConversionDemo {
    @ParameterizedTest
    @ValueSource(strings = ["01.01.2023", "31.12.2023"])
    fun testWithExplicitJavaTimeConverter(
        @JavaTimeConversionPattern("dd.MM.yyyy") argument: LocalDate
    ) {
        assertEquals(2023, argument.year)
    }
}