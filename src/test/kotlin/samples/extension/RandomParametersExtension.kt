package samples.extension

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.api.extension.ParameterResolutionException
import org.junit.jupiter.api.extension.ParameterResolver
import java.lang.reflect.Parameter


/**
 * `RandomParametersExtension` showcases the [ParameterResolver]
 * extension API of JUnit 5 by providing injection support for random values at the
 * method parameter level.
 *
 *
 * For real world use cases for this and other extension points, check out
 * the extensions provided by the Spring and Mockito projects among others.
 *
 *
 * Please refer to the
 * [
 * Third-party Extensions wiki page](https://github.com/junit-team/junit5/wiki/Third-party-Extensions) for additional references.
 *
 * @since 5.2
 */
class RandomParametersExtension : ParameterResolver {
    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.VALUE_PARAMETER)
    annotation class Random

    override fun supportsParameter(parameterContext: ParameterContext, extensionContext: ExtensionContext): Boolean {
        return parameterContext.isAnnotated(Random::class.java)
    }

    override fun resolveParameter(parameterContext: ParameterContext, extensionContext: ExtensionContext): Any {
        return getRandomValue(parameterContext.getParameter(), extensionContext)
    }

    private fun getRandomValue(parameter: Parameter, extensionContext: ExtensionContext): Any {
        val type = parameter.type
        val random: java.util.Random = extensionContext.getRoot().getStore(ExtensionContext.Namespace.GLOBAL) //
            .getOrComputeIfAbsent<java.util.Random>(java.util.Random::class.java)
        if (Int::class.javaPrimitiveType == type) {
            return random.nextInt()
        }
        if (Double::class.javaPrimitiveType == type) {
            return random.nextDouble()
        }
        throw ParameterResolutionException("No random generator implemented for $type")
    }
}