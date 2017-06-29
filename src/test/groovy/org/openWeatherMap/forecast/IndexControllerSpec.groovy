package org.openWeatherMap.forecast

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.web.GroovyPageUnitTestMixin
import org.openWeatherMap.forecast.interceptors.UrlInterceptor
import spock.lang.Specification

import static java.util.Objects.equals

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestMixin(GroovyPageUnitTestMixin)
@TestFor(IndexController)
@Mock([City, UrlInterceptor])
class IndexControllerSpec extends Specification {
    OwmClientService owmClientService
    long testId = 1

    def setup() {
        owmClientService = Mock(OwmClientService)
        controller.owmClientService = owmClientService

        City city = new City()
        city.setId(testId)
        city.save(flush: true)
    }

    void "Test the index action returns correct model and view"() {
        given:

        when: "Index action is executed"
        controller.index()

        then: "The model and view are rendered correctly"
        equals(view, '/index')
        model.containsValue(City.list())
    }

    void "Test the show action returns correct model and view"() {
        given:
        params.id = testId

        when: "Show action is executed"
        controller.show()

        then: "The model and view are rendered correctly"
        equals(view, '/show')
        equals(model.city.id, testId)
    }

    void "Test the update action returns correct model and view"() {
        given:
        params.id = testId

        when: "Update action is executed"
        controller.update()

        then: "The model and view are rendered correctly"
        response.redirectedUrl == "/index/show/${testId}"
    }

}
