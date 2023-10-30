package samples.basic

import io.github.oshai.kotlinlogging.KotlinLogging
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Named.named
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.io.File


class AdvancedDisplayNameDemo {

    private val log = KotlinLogging.logger {}

    @DisplayName("Display name of container")
    @ParameterizedTest(name = "{index} ==> the rank of ''{0}'' is {1}")
    @CsvSource(
        "apple, 1",
        "banana, 2",
        "'lemon, lime', 3"
    )
    fun testWithCustomDisplayNames(fruit: String?, rank: Int) {
        log.info { "$fruit, $rank" }
    }

    @DisplayName("A parameterized test with named arguments")
    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("namedArguments")
    fun testWithNamedArguments(file: File) {
        log.info { "$file" }
    }

    companion object {
        @JvmStatic
        fun namedArguments() =
            listOf(
                Arguments.of(named("An important file", File("path1"))),
                Arguments.of(named("Another file", File("path2")))
            )
    }
}