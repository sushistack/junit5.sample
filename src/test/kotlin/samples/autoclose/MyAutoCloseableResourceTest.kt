package samples.autoclose

import com.sushistack.MyAutoCloseableResource
import io.github.oshai.kotlinlogging.KotlinLogging
import org.junit.jupiter.api.AutoClose
import org.junit.jupiter.api.Test

class MyAutoCloseableResourceTest {

    private val log = KotlinLogging.logger {}

    @AutoClose
    var resource: MyAutoCloseableResource = MyAutoCloseableResource()

    @Test
    fun testUsingResource() {
        log.info { resource.doSomething() }
    }
}