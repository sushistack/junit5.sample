package samples.extension

import extensions.TimingExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import java.lang.Thread.sleep

class InstanceRegisterExtensionDemo {
    @RegisterExtension
    private val timingExtension: TimingExtension = TimingExtension()
    // 아래 테스트 같이 Extension 이 잘 동작 하는 것을 확인할 수 있다.

    @Test
    fun sleep20ms() {
        sleep(20)
        //[main] INFO extensions.TimingExtension -- Method [sleep20ms] took 30 ms.
    }

    @Test
    fun sleep50ms() {
        sleep(50)
        //[main] INFO extensions.TimingExtension -- Method [sleep50ms] took 53 ms.
    }
}