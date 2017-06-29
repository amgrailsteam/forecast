package org.openWeatherMap.forecast.task

import org.openWeatherMap.forecast.City

import static grails.util.Holders.applicationContext

class UpdateTask implements Task {

    @Override
    void executeTask() {
        City.withNewSession {
            City.list().each { city ->
                applicationContext.owmClientService.updateForecast(city)
            }
        }
    }
}
