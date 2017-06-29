package org.openWeatherMap.forecast.config

import grails.util.Holders
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ApplicationConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class)

    static final String OWM_REQUEST_URI = "owmRequestUrl"
    static final String OWM_REQUEST_KEY = "owmRequestKey"
    static final String CITIES_ID_LIST = "citiesIds"
    static final String SCHEDULER_CRON = "schedulerCron"


    private static ConfigObject getApplicationConfig() {
        return Holders.config.org.openWeatherMap.forecast
    }

    public static def getConfigValue(String configKey) {
        def configValue = applicationConfig."${configKey}"
        if (!configValue) {
            LOGGER.error("Config value for '${configKey}' could not be resolved")
            return
        }
        configValue
    }
}