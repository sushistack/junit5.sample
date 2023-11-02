package samples.timeout

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import org.junit.jupiter.api.Timeout.ThreadMode
import java.util.concurrent.TimeUnit

class TimeoutDemo {

    @BeforeEach
    @Timeout(5)
    fun setUp() {
        // sleep(6000)
        // fails if execution time exceeds 5 seconds
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    fun failsIfExecutionTimeExceeds500Milliseconds() {
        // fails if execution time exceeds 500 milliseconds
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
    //threadMode =
    // SAME_THREAD 메인 스레드에서 Assertion 진행
    // SEPARATE_THREAD = 별도의 스레드에서 Assertion 진행 (부작용 발생 가능)
    // INFERRED = 구성 파라미터를 통해 스레드 모드를 결정, 유효한 파라미터가 없을 경우 SAME_THREAD
    fun failsIfExecutionTimeExceeds500MillisecondsInSeparateThread() {
        // fails if execution time exceeds 500 milliseconds, the test code is executed in a separate thread
    }
}