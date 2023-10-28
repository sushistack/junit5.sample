package samples.aggregator

import io.github.oshai.kotlinlogging.KotlinLogging
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.aggregator.AggregateWith
import org.junit.jupiter.params.aggregator.ArgumentsAccessor
import org.junit.jupiter.params.aggregator.ArgumentsAggregator
import org.junit.jupiter.params.provider.CsvSource
import java.time.LocalDate


class AggregatorDemo {

    private val log = KotlinLogging.logger {}

    @ParameterizedTest
    @CsvSource(
        "Jane, Doe, F, 1990-05-20",
        "John, Doe, M, 1990-10-22"
    )
    fun testWithArgumentsAggregator(@AggregateWith(PersonAggregator::class) person: Person?) {
        // perform assertions against person
        log.info { "person = $person" }
    }

    @ParameterizedTest
    @CsvSource(
        "Jane, Doe, F, 1990-05-20",
        "John, Doe, M, 1990-10-22"
    )
    fun testWithCustomAggregatorAnnotation(@CsvToPerson person: Person?) {
        // perform assertions against person
        log.info { "person = $person" }
    }

    class PersonAggregator : ArgumentsAggregator {
        override fun aggregateArguments(arguments: ArgumentsAccessor, context: ParameterContext): Person {
            return Person(
                arguments.getString(0),
                arguments.getString(1),
                arguments.get(2, Gender::class.java),
                arguments.get(3, LocalDate::class.java)
            )
        }
    }

    data class Person(
        val firstName: String,
        val lastName: String,
        val gender: Gender,
        val dateOfBirth: LocalDate
    )

    enum class Gender {
        M, F;
    }
}