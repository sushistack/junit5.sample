import io.github.oshai.kotlinlogging.KotlinLogging
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

class RepeatedTestsDemo {
    private val log = KotlinLogging.logger {}

    @BeforeEach
    fun beforeEach(testInfo: TestInfo, repetitionInfo: RepetitionInfo) {
        val currentRepetition = repetitionInfo.currentRepetition
        val totalRepetitions = repetitionInfo.totalRepetitions
        val methodName = testInfo.testMethod.get().name
        log.info { "About to execute repetition $currentRepetition of $totalRepetitions for $methodName" }
    }

    @RepeatedTest(5)
    fun repeatedTestWithRepetitionInfo(repetitionInfo: RepetitionInfo) {
        assertEquals(5, repetitionInfo.totalRepetitions)
    }

    @RepeatedTest(value = 8, failureThreshold = 2)
    fun repeatedTestWithFailureThreshold(repetitionInfo: RepetitionInfo) {
        // Simulate unexpected failure every second repetition
        if (repetitionInfo.currentRepetition % 2 == 0) {
            fail("Boom!")
        }
    }

    @RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    fun customDisplayName(testInfo: TestInfo) {
        assertEquals("Repeat! 1/1", testInfo.displayName)
    }

    @RepeatedTest(value = 1, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Details...")
    fun customDisplayNameWithLongPattern(testInfo: TestInfo) {
        assertEquals("Details... :: repetition 1 of 1", testInfo.displayName)
    }
}