import TestLifeCycleLogger.Companion.sharedVariable
import io.github.oshai.kotlinlogging.KotlinLogging
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestInterfaceDemo:
    TestInterfaceDynamicTestsDemo, // 같이 실행 됨
    TestLifeCycleLogger, // TestLifeCycleLogger -- About to execute [isEqualValue()]
    TimeExecutionLogger // extensions.TimingExtension -- Method [isEqualValue] took 2 ms.
{
    private val log = KotlinLogging.logger {}
    @Test
    fun isEqualValue() {
        log.info { sharedVariable } // 여기서 상속 받은 interface 의 static variable 사용 가능
        assertEquals(1, "a".length, "is always equal")
    }
}