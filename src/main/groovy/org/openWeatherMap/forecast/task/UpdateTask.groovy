package org.openWeatherMap.forecast.task

import org.openWeatherMap.forecast.City

import static grails.util.Holders.applicationContext

class UpdateTask implements Task {

    /**
     * Task updates the forecast data for each item in City domain.
     * Is used by the scheduler for automatic updates
     */

    @Override
    void executeTask() {
        City.withNewSession {
            City.list().each { city ->
                applicationContext.owmClientService.updateForecast(city)
            }
        }
    }
}
