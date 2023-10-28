package samples.aggregator

import org.junit.jupiter.params.aggregator.AggregateWith
import samples.aggregator.AggregatorDemo.PersonAggregator

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.VALUE_PARAMETER)
@AggregateWith(PersonAggregator::class)
annotation class CsvToPerson