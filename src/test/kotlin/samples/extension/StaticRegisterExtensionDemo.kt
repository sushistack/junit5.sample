package samples.extension
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.api.extension.ParameterResolver
import org.junit.jupiter.api.extension.RegisterExtension
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

class StaticRegisterExtensionDemo {
    companion object {
        // @ExtendWith 대신 아래와 같이 Extension 을 등록할 수 있다.
        // 이 Extension 은 한 번만 초기화 되고 모든 테스트가 공유하게 된다.
        @RegisterExtension
        val integerResolver: IntegerResolver = IntegerResolver

        @JvmStatic
        fun factoryMethodWithArguments(quantity: Int) =
            listOf(
                arguments("$quantity apples"),
                arguments("$quantity lemons")
            )
    }

    @ParameterizedTest
    @MethodSource("factoryMethodWithArguments")
    fun testWithFactoryMethodWithArguments(argument: String) {
        assertTrue(argument.startsWith("2"))
    }

    // ParameterResolver 역할: 테스트 메소드 에 필요한 값 자동 주입
    // 설정 값 / 외부 응답 값 주입할 때, 사용 하면 좋을 것 같음
    object IntegerResolver : ParameterResolver {
        override fun supportsParameter(parameterContext: ParameterContext, extensionContext: ExtensionContext): Boolean =
            parameterContext.parameter.type == Int::class.javaPrimitiveType

        override fun resolveParameter(parameterContext: ParameterContext, extensionContext: ExtensionContext): Any = 2
    }
}

