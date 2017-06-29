package org.openWeatherMap.forecast

import grails.converters.JSON
import org.apache.http.client.utils.URIBuilder
import org.grails.web.json.JSONElement
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import static org.apache.http.HttpStatus.SC_OK
import static org.openWeatherMap.forecast.config.ApplicationConfig.*

class OwmClientService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OwmClientService.class)
    OwmParserService owmParserService

    JSONElement getDataFromOwm(City city) {
        URL owmRestUrl = new URIBuilder(getConfigValue(OWM_REQUEST_URI)).
                addParameter("appid", getConfigValue(OWM_REQUEST_KEY)).
                addParameter("id", city.id.toString()).build().toURL()
        JSON.parse(owmRestUrl.getText())
    }

    def updateForecast(City city) {
        JSONElement responseFromOwm = getDataFromOwm(city)
        if (responseFromOwm?.getAt('cod') != SC_OK.toString()) {
            LOGGER.error("Unsuccessful request to OWM for city: ${city.id}")
            return
        }

        owmParserService.updateCityFromJson(city, responseFromOwm)
        if (!city.save(flush: true)) {
            LOGGER.error("Unable to flush updated forecast data for city: ${city.id}")
        }
        LOGGER.debug("Updated forecast for city: ${city.id}")
    }
}
