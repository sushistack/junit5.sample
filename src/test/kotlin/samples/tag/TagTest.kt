package samples.tag

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class TagTest {

    @Test
    @Tag("fast")
    fun fastTest() {
        println("Fast test executed")
    }

    @Test
    @Tag("slow")
    fun slowTest() {
        println("Slow test executed")
    }

    @Test
    @Tag("database")
    fun databaseTest() {
        println("Database test executed")
    }

    /**
     * test {
     *     useJUnitPlatform {
     *         // "fast" 태그가 있는 테스트만 실행
     *         includeTags 'fast'
     *
     *         // "slow" 태그가 있는 테스트를 제외하고 실행
     *         excludeTags 'slow'
     *     }
     * }
     */

}