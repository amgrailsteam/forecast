package org.openWeatherMap.forecast.interceptors

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.openWeatherMap.forecast.City
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(DocResolveInterceptor)
@Mock([DocResolveInterceptor, City])
class DocResolveInterceptorSpec extends Specification {
    static Long existingId = 1111
    static Long nonExistingId = 2222


    def setup() {
        City city = new City()
        city.setId(existingId)
        city.save(flush: true)
    }

    def cleanup() {

    }

    void "City with existing id is retrieved succesfully"() {
        when:
        withRequest(controller: "index", action: "show")
        interceptor.request.addParameter('id', value.toString())

        then:
        expected == interceptor.before()

        where:
        value         | expected
        existingId    | true
        nonExistingId | false
    }
}
