package samples.interfaces

import samples.extension.TimingExtension
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.extension.ExtendWith

@Tag("timed")
@ExtendWith(TimingExtension::class)
interface TimeExecutionLogger