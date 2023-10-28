package samples.interfaces
import io.github.oshai.kotlinlogging.KotlinLogging
import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
interface TestLifeCycleLogger {
    companion object {
        private val log = KotlinLogging.logger {}
        lateinit var sharedVariable: String
    }

    // PER_CLASS 일 때, 인스턴스 메서드로 사용할 수 있음
    @BeforeAll
    fun beforeAllTests() {
        log.info { "Before all tests" }
        sharedVariable = "I'm Shared Variable !!"
    }

    // PER_CLASS 일 때, 인스턴스 메서드로 사용할 수 있음
    @AfterAll
    fun afterAllTests() {
        log.info {"After all tests" }
    }

    @BeforeEach
    fun beforeEachTest(testInfo: TestInfo) {
        log.info { String.format("About to execute [%s]", testInfo.displayName) }
    }

    @AfterEach
    fun afterEachTest(testInfo: TestInfo) {
        log.info { String.format("Finished executing [%s]", testInfo.displayName) }
    }
}