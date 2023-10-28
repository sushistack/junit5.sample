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

    // static 으로 Extension 을 구현 하기 위해 서는 아래와 같이 ParameterResolver 를 구현 해야 한다.
    object IntegerResolver : ParameterResolver {
        override fun supportsParameter(parameterContext: ParameterContext, extensionContext: ExtensionContext): Boolean =
            parameterContext.parameter.type == Int::class.javaPrimitiveType

        override fun resolveParameter(parameterContext: ParameterContext, extensionContext: ExtensionContext): Any = 2
    }
}

