package org.openWeatherMap.forecast

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.joda.time.LocalDateTime
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(City)
@Mock([City, Forecast])
class CitySpec extends Specification {
    City city

    def setup() {
        city = new City()
    }

    def cleanup() {
    }

    void "test 'name' field validation"() {
        when:
        city.name = value

        then:
        expected == city.validate(['name'])
        city.errors['name']?.code == expectedErrorCode

        where:
        value     | expected | expectedErrorCode
        'x' * 255 | true     | null
        ''        | true     | null
        'x' * 256 | false    | 'maxSize.exceeded'
    }

    void "test 'countryCode' field validation"() {
        when:
        city.countryCode = value

        then:
        expected == city.validate(['countryCode'])
        city.errors['countryCode']?.code == expectedErrorCode

        where:
        value | expected | expectedErrorCode
        'A'   | false    | 'minSize.notmet'
        'AM'  | true     | null
        'AMD' | false    | 'maxSize.exceeded'
    }

    def "test getCurrentForecast() method"() {
        given:
        city.addToForecasts(new Forecast()).addToForecasts(new Forecast()).addToForecasts(new Forecast())

        when: "getCurrentForecast is called"
        def result = city.getCurrentForecast()

        then: "The result is correct"
        city.forecasts.indexOf(result) == 0
    }

    def "test beforeUpdate() method"() {
        given:
        city = new City()

        when: "The beforeUpdate function is executed"
        city.beforeUpdate()

        then: "The logic in beforeUpdate is executed correctly"
        city.lastUpdate.toLocalDate() == LocalDateTime.now().toLocalDate()
    }
}
