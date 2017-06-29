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

    /**
     * Method for requesting forecast data for the city from OWM
     * @param city
     * @return response from OWM parsed to JSON
     */
    JSONElement getDataFromOwm(City city) {
        URL owmRestUrl = new URIBuilder(getConfigValue(OWM_REQUEST_URI)).
                addParameter("appid", getConfigValue(OWM_REQUEST_KEY)).
                addParameter("id", city.id.toString()).build().toURL()
        JSON.parse(owmRestUrl.getText())
    }

    /**
     * Method for updating forecast data for the city based on json from OWM
     * @param city
     */
    void updateForecast(City city) {
        JSONElement responseFromOwm = getDataFromOwm(city)
        if (responseFromOwm?.getAt('cod') != SC_OK.toString()) {
            LOGGER.error("Unsuccessful request to OWM for city: ${city.id}")
            return
        }

        owmParserService.updateCityFromJson(city, responseFromOwm)
        if (!city.merge(flush: true)) {
            LOGGER.error("Unable to flush updated forecast data for city: ${city.id}")
        }
        LOGGER.debug("Updated forecast for city: ${city.id}")
    }
}
