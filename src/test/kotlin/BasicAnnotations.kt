import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BasicAnnotations {
    lateinit var name: String

    @BeforeEach
    fun setup() {
        name = "test"
    }

    @Test
    @DisplayName(value = "디스플레이 네임 테스트.")
    fun displayNameTest() {
        println(name)
    }
}