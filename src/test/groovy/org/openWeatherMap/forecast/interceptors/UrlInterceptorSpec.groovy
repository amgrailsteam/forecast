package org.openWeatherMap.forecast.interceptors


import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UrlInterceptor)
class UrlInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Test request interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"request")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
