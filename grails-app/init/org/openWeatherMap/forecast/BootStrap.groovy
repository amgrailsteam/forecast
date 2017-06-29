package org.openWeatherMap.forecast

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import static org.openWeatherMap.forecast.config.ApplicationConfig.CITIES_ID_LIST
import static org.openWeatherMap.forecast.config.ApplicationConfig.getConfigValue

class BootStrap {
    private static final Logger LOGGER = LoggerFactory.getLogger(BootStrap.class)

    def init = { servletContext ->

        getConfigValue(CITIES_ID_LIST).each {
            City city = new City()
            city.setId(it)
            if (!city.save(flush: true)) {
                LOGGER.error("Could not bootstrap predefined cities list!")
            }
        }
    }

    def destroy = {
    }
}
