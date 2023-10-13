import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BasicAnnotations {
    companion object {
        var age = 1
        @JvmStatic
        @BeforeAll
        fun setupOnce() {
            age = 2
        }
    }

    lateinit var name: String

    @BeforeEach
    fun setup() {
        name = "test"
    }

    @Test
    @DisplayName(value = "디스플레이 네임 테스트.")
    fun displayNameTest() {
        println(name)
        println(age)
    }
}