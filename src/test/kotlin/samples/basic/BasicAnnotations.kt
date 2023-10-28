package samples.basic

import org.junit.jupiter.api.*

class BasicAnnotations {
    companion object {
        var age = 1
        @JvmStatic
        @BeforeAll
        fun setupOnce() {
            age = 2
        }

        @JvmStatic
        @AfterAll
        fun teardownAll() {
            age = 1
        }
    }

    lateinit var name: String

    @BeforeEach
    fun setup() {
        name = "test"
    }

    @Test
    @Disabled("테스트 비활성화")
    @DisplayName(value = "디스플레이 네임 테스트.")
    fun displayNameTest() {
        println(name)
        println(age)
    }

    @AfterEach
    fun teardown() {
        println(name)
    }
}