package org.openWeatherMap.forecast.interceptors

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.web.http.HttpHeaders
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UrlInterceptor)
@Mock(UrlInterceptor)
class UrlInterceptorSpec extends Specification {

    def setup() {
    }

    def cleanup() {

    }

    void "Url with valid id passes interceptor"() {
        when:
        withRequest(controller: "index", action: "show")
        interceptor.request.addParameter('id', "123")

        then:
        interceptor.before()
    }

}
