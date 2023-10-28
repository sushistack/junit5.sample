package samples.extension

import io.github.oshai.kotlinlogging.KotlinLogging
import org.junit.jupiter.api.extension.AfterTestExecutionCallback
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ExtensionContext.Store
import java.lang.reflect.Method


class TimingExtension : BeforeTestExecutionCallback, AfterTestExecutionCallback {
    @Throws(Exception::class)
    override fun beforeTestExecution(context: ExtensionContext) {
        getStore(context).put(START_TIME, System.currentTimeMillis())
    }

    @Throws(Exception::class)
    override fun afterTestExecution(context: ExtensionContext) {
        val testMethod: Method = context.requiredTestMethod
        val startTime = getStore(context).remove(START_TIME, Long::class.javaPrimitiveType)
        val duration = System.currentTimeMillis() - startTime

        log.info { String.format("Method [%s] took %s ms.", testMethod.name, duration) }
    }

    private fun getStore(context: ExtensionContext): Store {
        return context.getStore(ExtensionContext.Namespace.create(javaClass, context.requiredTestMethod))
    }

    companion object {
        private val log = KotlinLogging.logger {}

        private const val START_TIME = "start time"
    }
}