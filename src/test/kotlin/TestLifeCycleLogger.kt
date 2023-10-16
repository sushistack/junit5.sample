
import io.github.oshai.kotlinlogging.KotlinLogging
import org.junit.jupiter.api.*

class TestLifeCycleLogger {

    companion object {
        val log = KotlinLogging.logger {}

        @JvmStatic
        @BeforeAll
        fun beforeAllTests() {
            log.info { "Before all tests" }
        }

        @JvmStatic
        @AfterAll
        fun afterAllTests() {
            log.info {"After all tests" }
        }
    }


    @BeforeEach
    fun beforeEachTest(testInfo: TestInfo) {
        log.info {
            String.format(
                "About to execute [%s]",
                testInfo.displayName
            )
        }
    }

    @AfterEach
    fun afterEachTest(testInfo: TestInfo) {
        log.info { String.format("Finished executing [%s]", testInfo.displayName) }
    }

    @Test
    fun test() {
    }
}